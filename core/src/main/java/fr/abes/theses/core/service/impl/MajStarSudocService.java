package fr.abes.theses.core.service.impl;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.process.ProcessCBS;
import fr.abes.cbs.utilitaire.Constants;
import fr.abes.cbs.utilitaire.Utilitaire;
import fr.abes.theses.core.api.Starsudoc;
import fr.abes.theses.core.service.IMajStarSudocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class MajStarSudocService implements IMajStarSudocService {
    private ProcessCBS clientBiblio;
    private ProcessCBS clientExpl;

    @Value("${sudoc.serveur}")
    private String serveurIp;
    @Value("${sudoc.port}")
    private String serveurPort;
    @Value("${sudoc.passwdRcr")
    private String passwdRcr;
    @Value("${sudoc.loginM4001")
    private String loginM4001;
    @Value("${sudoc.passwdM4001")
    private String passM4001;

    public MajStarSudocService() {
        this.clientBiblio = new ProcessCBS();
        this.clientExpl = new ProcessCBS();
    }

    @Override
    public void authenticateBiblio() throws CBSException {
        this.clientBiblio.authenticate(serveurIp, serveurPort, loginM4001, passM4001);
    }

    /**
     * <b>La mise à jour ou création de la thèse, niveau biblio et exemplaires si il y en a
     * </b>
     * <p>
     * La thèse venant de Star est au format Marc Xml Sudoc
     * <ul>
     * <li></li>
     * <li></li>
     * </ul>
     * </p>
     *
     * @param marcXml la thèse en MarcXml Sudoc sous forme de String
     * @param xslStar le nom du fichier xml avec champs crées dans Star
     * @return le résultat de la création/modification de la thèse
     * @see fr.abes.cbs
     */
    @Override
    public String majStarSudoc(String marcXml, String xslStar) {
        /**
         * le résultat du catalogage de la thèse avec balise XML
         */
        StringBuilder resultCatalogageStar = new StringBuilder("<THESE>");
        /**
         * Une instance d'une création ou m.à.j d'une thèse venant de STAR
         */
        Starsudoc theseStar = new Starsudoc();
        //on remplace dans la thèse MarcXml les é par StringE9+StringAccent
        marcXml = marcXml.replaceAll("é", Constants.STR_E9 + Constants.STR_769);
        //on récupère le fichier xml qui contient les zones de créées dans STAR
        try {
            String resuStar = theseStar.transfTheseFromStarToMarcXml(marcXml); // on a transformé la thèse STAR en Marc
            resultCatalogageStar.append("<BIBLIO><NOTICESTAR>").append(resuStar.replaceAll("<", "&lt").replaceAll(">", "&gt")).append("</NOTICESTAR>");
            String resu;

            if (!noticeBiblioFinded(theseStar)) {
                resultCatalogageStar.append(creerNoticeBiblioEtExemplaires(theseStar));
            } else {
                resultCatalogageStar.append(fusionNoticeStarEtSudoc(theseStar, xslStar));
            }
            clientBiblio.disconnect();
        } catch (CBSException ex) {
            log.error("exception " + ex.getMessage());
        }
        return resultCatalogageStar.append("</THESE>").toString();
    }

    private boolean noticeBiblioFinded(Starsudoc theseStar) throws CBSException {
        //on cherche si la thèse STAR est dans le Sudoc en utilisant le numéro source (zone unimarc 002)
        String resu = clientBiblio.search("che sou " + theseStar.getNumSource());
        if (clientBiblio.getNbNotices() == 0) {
            //pas de notice avec recherche sur le num. source donc on lance la recherche sur le num. de thèse (zone unimarc 029)
            resu = clientBiblio.search("che num " + theseStar.getNumThese());
            if (clientBiblio.getNbNotices() >= 1) {
                //quand la notice trouvée est une thèse papier, on doit créer la notice biblio electronique
                if (theseStar.estThesePapier(resu)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String creerNoticeBiblioEtExemplaires(Starsudoc theseStar)  {
        //la thèse n'existe pas dans le Sudoc, ou existe pour la version papier, on va la créer (niveau biblio) dans le Sudoc
        StringBuilder resu = new StringBuilder(creerTheseBiblio(theseStar.getNoticeBiblio()));
        resu.append("</BIBLIO>");
        if (theseStar.getListExpl().length() > 0) {
            //il y a 1 ou plusieurs exemplaires dans la notice STAR à créer dans la notice Sudoc
            resu.append(creerAllExplStar(theseStar));
        }
        return resu.toString();
    }

    private String fusionNoticeStarEtSudoc(Starsudoc theseStar, String xslStar) throws CBSException {
        StringBuilder resultARetourner = new StringBuilder();
        //la notice de thèse existe dans le Sudoc, on va fusionner notice STAR et notice Sudoc
        String resu = clientBiblio.affUnma();
        //On affiche la thèse en Unimarc pour récupérer toutes les données biblio et exemplaires
        String resuEdit = Utilitaire.recupEntre(clientBiblio.editer("1"), Constants.STR_1F, Constants.STR_0D + Constants.STR_0D + Constants.STR_1E);
        String[] listeZones = resuEdit.split(Constants.STR_0D);
        // on sépare de la notice Sudoc la partie biblio et exemplaires si il y en a
        String[] sudocExpl = null;//contient les éventuels exemplaires de la notice du Sudoc
        if (clientBiblio.hasExpl) {
            //il y a des exemplaires dans la notice Sudoc
            sudocExpl = resu.substring(resu.indexOf("<BR>["), resu.length()).split("<BR>\\["); //contient la liste des exemplaires de la notice Sudoc
        }
        //on passe la notice en Edition pour récupérer les éventuels zones systèmes protégées de la notice Sudoc
        List<String> vecteurSudoc = Arrays.asList(listeZones);
        StringBuilder fusion = theseStar.fusionThese(theseStar.getNoticeBiblio(), vecteurSudoc, xslStar);
        resu = majTheseBiblio(fusion.toString());
        //on a fusionné la notice biblio
        resultARetourner.append(resu);
        //La notice biblio du Sudoc a été mise à jour en fonction de la notice STAR
        if (sudocExpl != null) {
            //La notice Sudoc a des exemplaires
            //On va supprimer dans la notice Sudoc tous les exemplaires qui contiennent un 991 $aexemplaire créé automatiquement par STAR
            String[] explRCR;
            for (int i = 1; i < sudocExpl.length; i++) {
                explRCR = sudocExpl[i].split("<BR>e");
                for (int j = 1; j < explRCR.length; j++) {
                    if (explRCR[j].contains("automatiquement par STAR")) {
                        String numexpl = explRCR[j].substring(0, 2);
                        //on récupère le rcr de l'exemplaire en cours
                        String rcr = explRCR[j].substring(explRCR[j].indexOf("930 ##$b") + 8, explRCR[j].indexOf("930 ##$b") + 17);
                        //on ouvre une session avec le CBS pour le rcr en cours
                        //Les rcr rattachés à un ILN >199 n'ont pas de login CBS - on utilise donc dans ce cas, le rcr 341720008 pour ouvrir la session
                        if (Integer.parseInt(clientBiblio.ilnRattachement(rcr)) > 199) {
                            rcr = "341720008";
                        }
                        clientExpl.authenticate(this.serveurIp, this.serveurPort, "M" + rcr, passwdRcr);
                        clientExpl.search("che ppn " + clientBiblio.getPpnEncours());
                        //suppression de l'exemplaire
                        clientExpl.supExemplaire(numexpl);
                        clientExpl.disconnect();
                    }
                }
            }
        }
        if (theseStar.getListExpl().length() > 0) {
            //il y a 1 ou plusieurs exemplaires dans la notice STAR à créer dans la notice Sudoc
            resultARetourner.append(creerAllExplStar(theseStar));
        }
        return resultARetourner.toString();
    }

    /**
     * <b>Créer la notice biblio de la thèse venant de Star</b>
     * <p>
     * <ul>
     * <li>On utilise la méthode EnregistrerNew de la classe Cbs à laquelle on passe en paramètre NoticeBiblio</li>
     * <li>Le ppn de la notice créée est dans PpnEncours de CBSclient</li>
     *
     * </ul>
     * </p>
     *
     * @return le message succès/échec de la création, le ppn structuré avec balise
     */
    @Override
    public String creerTheseBiblio(String noticeBiblio) {
        StringBuilder resultCat = new StringBuilder("<CODERETOUR>");
        try {
            clientBiblio.enregistrerNew(noticeBiblio); //on crée la notice biblio
            //création notice biblio ok
            resultCat.append("OK</CODERETOUR>");
            resultCat.append("<PPN>" + clientBiblio.getPpnEncours() + "</PPN>");
        } catch (CBSException ex) {
            resultCat.append("NOK - Notice non créée</CODERETOUR>");
            resultCat.append("<MESSAGE>" + ex.getMessage() + "</MESSAGE>");
        }
        return resultCat.toString();
    }

    /**
     * <b>Mettre à jour dans le Sudoc, la notice biblio de la thèse venant de Star</b>
     * <p>
     * <ul>
     * <li>On utilise la méthode ModifierNotice de la classe Cbs à laquelle on passe en paramètre Notice et CbsClient.PPnEncours</li>
     * </ul>
     * </p>
     *
     * @param notice la notice
     * @return le message succès/échec de la m.à.j, le ppn structuré avec balise
     */
    @Override
    public String majTheseBiblio(String notice) {
        StringBuilder resultCat = new StringBuilder("<CODERETOUR>");
        try {
            clientBiblio.modifierNotice(clientBiblio.getPpnEncours(), notice);
            //création notice biblio ok
            resultCat.append("OK</CODERETOUR>");
            resultCat.append("<PPN>" + clientBiblio.getPpnEncours() + "</PPN>");
        } catch (Exception ex) {
            resultCat.append("NOK</CODERETOUR>");
            resultCat.append("<MESSAGE>" + ex.getMessage() + "</MESSAGE>");
        }
        return resultCat.append("</BIBLIO>").toString();
    }

    /**
     * <b>Crée les exemplaires de la notice de thèse si il y en a</b>
     * <p>utilise PpnEncours de l'objet Cbs</p>
     *
     * @param laTheseStar la thèse
     * @return le résultat du rajout d'exemplaire(s)
     * <p>
     * * @see Cbs#PPnEncours
     */
    private String creerAllExplStar(Starsudoc laTheseStar) {
        String[] tabExpl;
        StringBuilder resultExpl = new StringBuilder();
        try {
            if (laTheseStar.getListExpl().contains("E856 ")) {
                String e856 = laTheseStar.getListExpl().substring(0, laTheseStar.getListExpl().indexOf("930 ##"));
                laTheseStar.setListExpl(laTheseStar.getListExpl().substring(laTheseStar.getListExpl().indexOf("930 ##")));
                tabExpl = laTheseStar.getListExpl().split("930 ##");
                for (int i = 1; i < tabExpl.length; i++) {
                    tabExpl[i] = tabExpl[i] + e856;
                }
            } else {
                tabExpl = laTheseStar.getListExpl().split("930 ##");
            }
            if (tabExpl != null) {//pour chaque exemplaire à créer
                StringBuilder lercr;
                String expl;
                for (int i = 1; i < tabExpl.length; i++) {
                    tabExpl[i] = "930 ##" + tabExpl[i];
                    expl = tabExpl[i];
                    try {
                        lercr = new StringBuilder(expl.substring(expl.indexOf("930 ##$b") + 8, expl.indexOf("930 ##$b") + 9));
                        int k = 9;
                        while (!("$").equals(expl.substring(expl.indexOf("930 ##$b") + k, expl.indexOf("930 ##$b") + k + 1))) {
                            lercr.append(expl.substring(expl.indexOf("930 ##$b") + k, expl.indexOf("930 ##$b") + k + 1));
                            k++;
                        }
                    } catch (Exception ex) {
                        lercr = new StringBuilder("rcr non renseigné");
                    }
                    resultExpl.append("<EXEMPLAIRE><RCR>" + lercr + "</RCR><CODERETOUR>");
                    if (lercr.length() != 9) {
                        resultExpl.append("RCR ERRONE OU NON RENSEIGNE</CODERETOUR>");
                    } else {
                        //on regarde si le rcr a un ILN > 199
                        if (Integer.parseInt(clientExpl.ilnRattachement(lercr.toString())) > 199 && Integer.parseInt(clientExpl.ilnRattachement(lercr.toString())) <= 300) {
                            lercr = new StringBuilder("341720008");
                        }
                        clientExpl.authenticate(this.serveurIp, this.serveurPort, "M" + lercr, this.passwdRcr);
                        //on ouvre une session CBS avec le login du manager du rcr concerné
                        //et on créé l'exemplaire
                        resultExpl.append(creerExpl(tabExpl[i], clientBiblio.getPpnEncours()));
                        clientExpl.disconnect();
                    }
                    resultExpl.append("</EXEMPLAIRE>");
                }
            }
        } catch (CBSException ex) {
            log.error("Erreur CBS : " + ex.getMessage());
        }
        return resultExpl.toString();
    }

    /**
     * <b>Créer un exemplaire pour la thèse venant de Star</b>
     * <p>
     * <ul>
     * <li>On recherche la notice biblio de la thèse avec le PPN : méthode Search de la classe Cbs à laquelle on passe en paramètre  "che ppn n°ppn"</li>
     * <li>On passe la notice en édition : méthode Editer_Fbe de la classe Cbs</li>
     * <li>On utilise la méthode NewExemplaire de la classe Cbs </li>
     * </ul>
     * </p>
     *
     * @param exemplaire les données de l'exemplaire
     * @param lePPN      le ppn de la notice que l'on vient de créer ou modifier
     * @return le message succès/échec de la création et l'epn structuré avec balise
     */
    @Override
    public String creerExpl(String exemplaire, String lePPN) {
        StringBuilder resultCat = new StringBuilder();
        String resu;
        try {
            clientExpl.search("che ppn " + lePPN);
            clientExpl.creerExemplaire("e" + clientExpl.getNvNumEx());
            resu = clientExpl.newExemplaire(clientExpl.getNvNumEx() + " $bx" + Constants.SEP_CHAMP + exemplaire + Constants.SEP_CHAMP + "991 ##$aexemplaire créé automatiquement par STAR");
            //création exemplaire OK
            resultCat.append("OK</CODERETOUR>");
            String epn = resu.substring(resu.indexOf("A99 ") + 4, resu.indexOf("</TABLE"));
            resultCat.append("<EPN>" + epn + "</EPN>");
        } catch (CBSException ex) {
            resultCat.append("NOK</CODERETOUR>");
            resultCat.append("<MESSAGE>" + ex.getMessage() + "</message>");
            log.error("Erreur CBS : " + ex.getMessage());
        }
        return resultCat.toString();
    }
}

