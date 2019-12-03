package fr.abes.theses.service.impl;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.Biblio;
import fr.abes.cbs.notices.NoticeConcrete;
import fr.abes.cbs.notices.Zone;
import fr.abes.cbs.process.ProcessCBS;
import fr.abes.cbs.utilitaire.Constants;
import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.service.IMajStarSudocService;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MajStarSudocService implements IMajStarSudocService {
    @Autowired
    @Getter
    private DaoProvider dao;

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

    @Getter
    @Setter
    private String numSource;
    @Getter
    @Setter
    private String numThese;

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
     * @return le résultat de la création/modification de la thèse
     * @see fr.abes.cbs
     */
    @Override
    public String majStarSudoc(String marcXml) throws ExecutionControl.NotImplementedException {
        StringBuilder resultCatalogageStar = new StringBuilder("<THESE>");

        try {
            NoticeConcrete notice = new NoticeConcrete(marcXml);
            this.setNumSource(notice.getNoticeBiblio().findZones("002").get(0).findSousZone("$a").getValeur());
            this.setNumThese(notice.getNoticeBiblio().findZones("029").get(0).findSousZone("$b").getValeur());
            resultCatalogageStar.append("<BIBLIO><NOTICESTAR>").append(notice.toXml().replaceAll("<", "&lt").replaceAll(">", "&gt")).append("</NOTICESTAR>");

            if (!noticeBiblioElecFinded(notice)) {
                resultCatalogageStar.append(creerTheseBiblio(notice));
            } else {
                resultCatalogageStar.append(fusionNoticeStarEtSudoc(notice.getNoticeBiblio()));
            }
            resultCatalogageStar.append("</BIBLIO>");
            clientBiblio.disconnect();
        } catch (CBSException ex) {
            log.error("Erreur dans la création de la notice bibliographique " + ex.getMessage());
        }
        return resultCatalogageStar.append("</THESE>").toString();
    }

    private boolean noticeBiblioElecFinded(NoticeConcrete notice) throws CBSException {
        //on cherche si la thèse STAR est dans le Sudoc en utilisant le numéro source (zone unimarc 002)
        clientBiblio.search("che sou " + getNumSource());
        if (clientBiblio.getNbNotices() == 0) {
            //pas de notice avec recherche sur le num. source donc on lance la recherche sur le num. de thèse (zone unimarc 029)
            clientBiblio.search("che num " + getNumThese());
            if (clientBiblio.getNbNotices() >= 1) {
                //quand la notice trouvée est une thèse papier, on doit créer la notice biblio electronique
                if (!isElectronique(notice)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Détermine si la notice est un support papier ou électronique
     *
     * @param notice la notice bibliographique
     * @return true si support papier / false dans le cas contraire
     */
    private Boolean isElectronique(NoticeConcrete notice) {
        return (notice.getNoticeBiblio().findZones("008").get(0).findSousZone("$a").getValeur().startsWith("O")
                && notice.getNoticeBiblio().findZones("105").get(0).findSousZone("$b").getValeur().startsWith("m"));
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
    public String creerTheseBiblio(NoticeConcrete noticeBiblio) {
        StringBuilder resultCat = new StringBuilder("<CODERETOUR>");
        try {
            clientBiblio.enregistrerNew(noticeBiblio.toString()); //on crée la notice biblio
            //création notice biblio ok
            resultCat.append("OK</CODERETOUR>");
            resultCat.append("<PPN>" + clientBiblio.getPpnEncours() + "</PPN>");
        } catch (CBSException ex) {
            resultCat.append("NOK - Notice non créée</CODERETOUR>");
            resultCat.append("<MESSAGE>" + ex.getMessage() + "</MESSAGE>");
        }
        return resultCat.toString();
    }

    private String fusionNoticeStarEtSudoc(Biblio theseStar) throws CBSException, ExecutionControl.NotImplementedException {
        StringBuilder resultARetourner = new StringBuilder();
        //la notice de thèse existe dans le Sudoc, on va fusionner notice STAR et notice Sudoc
        clientBiblio.affUnma();
        Biblio noticeBiblio = new Biblio(clientBiblio.editer("1"));
        String fusion = fusionThese(theseStar, noticeBiblio);
        String resu = majTheseBiblio(fusion);
        resultARetourner.append(resu);
        return resultARetourner.toString();
    }

    /**
     * <b>Dans le cas d'une m.à.j, fusionne la notice STAR et la notice sudoc biblio avant l'envoi au Sudoc pour m.à.j</b>
     * <p>
     * <ul>
     * <li>La fusion se base sur un fichier qui liste les zones de la notice STAR qui vont écraser celles de la notice Sudoc</li>
     * </ul>
     * </p>
     *
     * @param noticeStar  la thèse venant de STAR convertie en Marc
     * @param noticeSudoc la notice biblio venant du Sudoc
     * @return la notice fusionnée
     */
    public String fusionThese(Biblio noticeStar, Biblio noticeSudoc) {
        Biblio noticeFusionnee = new Biblio();
        for (Zone zoneSudoc : noticeSudoc.getListeZones().values()) {
            if (getDao().getZonePrioritaire().findZoneByLabel(zoneSudoc.getLabelForOutput()) != null) {
                List<Zone> zoneStar = noticeStar.findZones(zoneSudoc.getLabelForOutput());
                if (zoneStar.size() == 0) {
                    noticeFusionnee.addZone(zoneSudoc);
                } else {
                    for (Zone zoneAEcrire : zoneStar) {
                        noticeFusionnee.addZone(zoneAEcrire);
                    }
                }
            } else {
                noticeFusionnee.addZone(zoneSudoc);
            }
        }
        return noticeFusionnee.toString();
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
    /*
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
*/
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

