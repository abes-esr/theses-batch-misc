package fr.abes.theses.api;

import fr.abes.cbs.utilitaire.Constants;
import fr.abes.cbs.utilitaire.Utilitaire;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe représentant une thèse venant de Star
 *
 * @author blondelle
 * @version 1.0
 */
public class Starsudoc {

    /**
     * La notice bibliographique de la thèse
     */
    @Getter
    private String noticeBiblio;
    /**
     * La liste des exemplaires d'une thèse
     */
    @Setter
    @Getter
    private String listExpl;
    /**
     * Le numéro source de la thèse qui correspond au champ 002 unimarc
     */
    @Getter
    private String numSource;
    /**
     * Le numéro de la thèse
     */
    @Getter
    private String numThese;

    /**
     * La thèse Star
     */
    public Starsudoc() {
        //no constructor
    }

    /**
     * <b>Transforme une thèse STAR en Marc Xml Sudoc et : </b>
     * <p>
     * <ul>
     * <li>en extrait la valeur du champ 002 dans NumSource</li>
     * <li>en extrait la valeur du champ 029 dans NumThese</li>
     * <li>sépare la partie biblio et exemplaires d'une notice Marc Xml Sudoc     *
     *     <ul>
     *       <li>partie biblio dans NoticeBiblio</li>
     *       <li>partie exemplaire(s) dans ListExpl</li>
     *     </ul></li>
     * </ul>
     * </p>
     *
     * @param theseXML   la thèse en XML
     *
     * @return la thèse en marc
     *
     * @see Utilitaire#recupEntre(String, String, String)
     * @see
     * @author FBE
     */
    public String transfTheseFromStarToMarcXml(String theseXML) {
        listExpl = null;
        String noticeMarc = Utilitaire.xml2Marc(theseXML);
        if (noticeMarc.substring(0,6).equals("002 $a")) {
            numSource = Utilitaire.recupEntre(noticeMarc, "002 $a", "$2STAR");
            numThese = extractNumThese(noticeMarc);
            if (noticeMarc.indexOf("930 ##") > 0) {
                if (noticeMarc.indexOf("E856 ") > 0) {
                    noticeBiblio = noticeMarc.substring(0, noticeMarc.indexOf("E856 "));
                    listExpl = noticeMarc.substring(noticeMarc.indexOf("E856 "));
                } else {
                    //il y a des exemplaires à créer
                    noticeBiblio = noticeMarc.substring(0, noticeMarc.indexOf("930 ##"));
                    listExpl = noticeMarc.substring(noticeMarc.indexOf("930 ##"));
                }
            } else {
                //pas d'exemplaire à créer
                noticeBiblio = noticeMarc;
            }
        }
        return noticeMarc;
    }

    /**
     * Extrait d'une notice Marc la valeur du champ 029
     * @param noticeMarc
     *
     * @return a valeur du champ 029
     */
    private String extractNumThese(String noticeMarc) {
        String zone029 = Utilitaire.recupEntre(noticeMarc, "029 ##$a", Constants.STR_0D);
        return zone029.substring(zone029.indexOf("$b") + 2, zone029.indexOf("$b") + 14);
    }

    /**
     * <b>Détermine si la notice Marc est un support papier ou électronique</b>
     * <p>se base sur :
     * <ul>
     * <li>la valeur du 008$a ET</li>
     * <li>la valeur du 105$b</li>
     * </ul>
     * Si 008$a contient "O" et 105$b contient "m" alors c'est un support électronique
     *
     * @param noticeMarc la notice au format Marc
     *
     * @return true si support papier / false dans le cas contraire
     */
    public Boolean estThesePapier(String noticeMarc) {
        Pattern pattern1 = Pattern.compile("<BR>008 \\$aO");
        Matcher matcher1 = pattern1.matcher(noticeMarc);
        String zone105= Utilitaire.recupEntre(noticeMarc, "<BR>105 ", "<BR>");
        return !(matcher1.find() && zone105.contains("$bm"));
    }


    /**
     * Sépare la partie biblio et exemplaires d'une notice marc
     * partie biblio dans NoticeBiblio + exemplaire
     * partie exemplaire(s) dans ListExpl
     *
     * @param noticeMarc   la notice de thèse en Marc
     */
    public void biblioExpl(String noticeMarc) {

        if (noticeMarc.indexOf("930 ##") > 0) {
            if (noticeMarc.contains("E856 ")) {
                noticeBiblio = noticeMarc.substring(0, noticeMarc.indexOf("E856 "));
                listExpl = noticeMarc.substring(noticeMarc.indexOf("E856 "), noticeMarc.length());
            } else {

                //il y a des exemplaires à créer
                noticeBiblio = noticeMarc.substring(0, noticeMarc.indexOf("930 ##"));
                listExpl = noticeMarc.substring(noticeMarc.indexOf("930 ##"), noticeMarc.length());
            }
        } else {
            //pas d'exemplaire à créer
            noticeBiblio = noticeMarc;
        }
    }


    /**
     * Transforme en liste le contenu de la feuille de style STAR
     * Cette feuille de style contient la liste des champs crées dans STAR
     * et qui sont prioritaires par rapport à ceux du Sudoc
     * @author FBE
     * @param fichChampsStar   la feuille de style STAR
     */
    public List<String> listeChampsStar(String fichChampsStar) throws FileNotFoundException, IOException {
        List<String> listeChps = new ArrayList<>();
        try {
            BufferedReader bufLecteur = new BufferedReader(new InputStreamReader(new FileInputStream(fichChampsStar)));
            String ligne = bufLecteur.readLine();
            String chp;
            while (ligne != null) {
                if (ligne.contains("tag")) {
                    chp = ligne.substring(ligne.indexOf("tag") + 5, ligne.indexOf("tag") + 8);
                    listeChps.add(chp);
                }
                ligne = bufLecteur.readLine();
            }
            bufLecteur.close();
            return listeChps;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace(); // Indique l'exception sur le flux d'erreur standard
            return listeChps;
        } finally {
            System.err.println("Fin de méthode");
        }
    }

    public Boolean estZoneSysteme(String zone) {
        Pattern pattern1 = Pattern.compile("\\x1bP\\p{Digit}\\p{Digit}\\p{Digit}");
        Pattern pattern2 = Pattern.compile("\\x1bD\\x1bP\\p{Digit}\\p{Digit}\\p{Digit}");
        Matcher matcher1 = pattern1.matcher(zone);
        Matcher matcher2 = pattern2.matcher(zone);
        return matcher1.find() || matcher2.find();


    }

    public Boolean estZoneD(String zone) {
        Pattern pattern = Pattern.compile("\\x1bD\\p{Digit}\\p{Digit}\\p{Digit}");
        Matcher matcher = pattern.matcher(zone);
        return matcher.find();
    }

    /**
     * <b>Dans le cas d'une m.à.j, fusionne la notice STAR et la notice sudoc biblio avant l'envoi au Sudoc pour m.à.j</b>
     * <p>
     * <ul>
     * <li>La fusion se base sur un fichier qui liste les zones de la notice STAR qui vont écraser celles de la notice Sudoc</li>
     * </ul>
     * </p>

     *
     * @param noticeStar la thèse venant de STAR convertie en Marc
     * @param noticeSudoc la partie biblio de la notice venant du Sudoc
     * @param zoneStar la liste des zones STAR prioritaires
     *
     * @return le message succès/échec de la m.à.j, le ppn structuré avec balise
     */
    public StringBuilder fusionThese(String noticeStar, List<String> noticeSudoc, String zoneStar) {
        //Fusionne 1 notice biblio Star et 1 notice biblio Sudoc de même numéro source pour mise à jour dans le Sudoc
        /* arguments :
         * 0 = Notice venant de Star
         * 1 = Notice du Sudoc
         * 2 = Liste des zones de Star prioritaires par rapport au Sudoc
         */
        int j = 0;
        int i = 0;
        String[] tabNoticeStar = noticeStar.split(Constants.STR_0D);
        String champEncoursStar;
        String champEncoursSudoc;
        StringBuilder fusion = new StringBuilder();
        Object element = noticeSudoc.get(j);
        try {
            List<String> listeStar = listeChampsStar(zoneStar); //Liste des champs prioritaires par rapport à ceux du Sudoc
            for (i = 0; i < tabNoticeStar.length && j < noticeSudoc.size(); i++) {
                champEncoursStar = tabNoticeStar[i].substring(0, 3);
                champEncoursSudoc = element.toString().substring(element.toString().indexOf(' ') - 3, element.toString().indexOf(' '));

                while (j < noticeSudoc.size() && champEncoursSudoc.matches("00[A-Z]")) {
                    if ((Constants.STR_ZOE).contains(element.toString())) {
                        fusion.append(constructLien(element.toString()) + Constants.STR_0D);
                    } else {
                        fusion.append(element.toString() + Constants.STR_0D);
                    }
                    j++;
                    element = noticeSudoc.get(j);
                    champEncoursSudoc = element.toString().substring(element.toString().indexOf(' ') - 3, element.toString().indexOf(" "));
                }
                while (j < noticeSudoc.size() && !champEncoursSudoc.equals(champEncoursStar) && Integer.valueOf(champEncoursSudoc) < Integer.valueOf(champEncoursStar)) {
                    //champ Star est <> champ Sudoc et champ Sudoc < champ Star
                    //donc on garde le champ Sudoc
                    if ((Constants.STR_ZOE).contains(element.toString())) {
                        fusion.append(constructLien(element.toString()) + Constants.STR_0D);
                    } else {
                        fusion.append(element.toString() + Constants.STR_0D);
                    }
                    j++;
                    element = noticeSudoc.get(j);
                    champEncoursSudoc = element.toString().substring(element.toString().indexOf(' ') - 3, element.toString().indexOf(' '));
                }
                if (!champEncoursSudoc.equals(champEncoursStar) && Integer.valueOf(champEncoursSudoc) > Integer.valueOf(tabNoticeStar[i].substring(0, 3))) {
                    //champ Star est <> champ Sudoc et champ Sudoc > champ Star
                    //donc on garde le champ Star
                    fusion.append(tabNoticeStar[i] + Constants.STR_0D);
                }
                if (champEncoursSudoc.equals(champEncoursStar)) {
                    //Les 2 champs sont égaux
                    if (estZoneSysteme(element.toString())) {
                        if (element.toString().contains(Constants.STR_ZOE)) {
                            fusion.append(constructLien(element.toString()) + Constants.STR_0D);
                        } else {
                            fusion.append(element.toString() + Constants.STR_0D);
                        }
                        j++;
                        element = noticeSudoc.get(j);
                    } else {
                        if (listeStar.contains(champEncoursStar) && !champEncoursStar.equals("200")) {
                            fusion.append(tabNoticeStar[i] + Constants.STR_0D);
                            j++;
                            while (j < noticeSudoc.size()) {
                                element = noticeSudoc.get(j);
                                champEncoursSudoc = element.toString().substring(element.toString().indexOf(' ') - 3, element.toString().indexOf(' '));
                                if (!champEncoursSudoc.equals(champEncoursStar)) {
                                    break;
                                } else {
                                    j++;
                                }
                            }
                        }
                        if (listeStar.contains(champEncoursStar) && champEncoursStar.equals("200")) {
                            List<String> zone200Star=new ArrayList<>(Arrays.asList(tabNoticeStar[i].split("\\$")));
                            List<String> zone200Sudoc=new ArrayList<>(Arrays.asList(element.toString().split("\\$")));
                            Pattern sszone = Pattern.compile("^[cdhiz]");
                            for (String s:zone200Sudoc) {
                                Matcher matcher = sszone.matcher(s) ;
                                if (matcher.find()) {
                                    zone200Star.add(s);
                                }
                            }
                            Collections.sort(zone200Star);
                            ListIterator<String> iterator = zone200Star.listIterator(1); // On précise la position initiale de l'iterator. Ici on le place à la fin de la liste
                            tabNoticeStar[i]=zone200Star.get(0);
                            while(iterator.hasNext()){
                                tabNoticeStar[i] = tabNoticeStar[i]+"$"+iterator.next();

                            }
                            fusion.append(tabNoticeStar[i] + Constants.STR_0D);
                            j++;
                            while (j < noticeSudoc.size()) {
                                element = noticeSudoc.get(j);
                                champEncoursSudoc = element.toString().substring(element.toString().indexOf(' ') - 3, element.toString().indexOf(' '));
                                if (!champEncoursSudoc.equals(champEncoursStar)) {
                                    break;
                                } else {
                                    j++;
                                }
                            }
                        }



                        if (!listeStar.contains(champEncoursStar)) {
                            element = noticeSudoc.get(j);
                            if (element.toString().contains(Constants.STR_ZOE)) {
                                fusion.append(constructLien(element.toString()) + Constants.STR_0D);
                            } else {
                                fusion.append(element.toString() + Constants.STR_0D);
                            }
                            j++;
                            element = noticeSudoc.get(j);
                            champEncoursSudoc = element.toString().substring(element.toString().indexOf(" ") - 3, element.toString().indexOf(" "));
                            //garder les champs sudoc !!!! A FAIRE !!!!!!!
                        }
                    }
                }
            }
            if (i < tabNoticeStar.length) {
                while (i < tabNoticeStar.length) {
                    fusion.append(tabNoticeStar[i] + Constants.STR_0D);
                    i++;
                }
            }
            if (j < noticeSudoc.size()) {
                while (j < noticeSudoc.size()) {
                    if (element.toString().contains(Constants.STR_ZOE)) {
                        fusion.append(constructLien(element.toString()) + Constants.STR_0D);
                    } else {
                        fusion.append(element.toString() + Constants.STR_0D);
                    }
                    j++;
                    element = noticeSudoc.get(j);
                    champEncoursSudoc = element.toString().substring(element.toString().indexOf(" ") - 3, element.toString().indexOf(" "));
                }
            }
            return fusion;
        } catch (Exception ex) {
            return fusion;
        }
    }

    private String constructLien(String vlien) {
        String lien = "";
        while (vlien.contains(Constants.STR_ZOE)) {
            lien = vlien.substring(0, vlien.indexOf("<a")) + vlien.substring(vlien.indexOf("\">") + 2, vlien.indexOf("</")) + vlien.substring(vlien.indexOf("a>") + 2, vlien.length());
            vlien = lien;
        }
        return lien;
    }
}

