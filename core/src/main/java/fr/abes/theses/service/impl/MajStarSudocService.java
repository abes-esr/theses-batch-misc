package fr.abes.theses.service.impl;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.Biblio;
import fr.abes.cbs.notices.NoticeConcrete;
import fr.abes.cbs.notices.SousZone;
import fr.abes.cbs.notices.Zone;
import fr.abes.cbs.process.ProcessCBS;
import fr.abes.cbs.utilitaire.Constants;
import fr.abes.cbs.zones.enumSousZones.Zone_214;
import fr.abes.cbs.zones.enumSousZones.Zone_219;
import fr.abes.cbs.zones.enumZones.EnumZones;
import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.service.IMajStarSudocService;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    @Value("${sudoc.passwdRcr}")
    private String passwdRcr;
    @Value("${sudoc.loginM4001}")
    private String loginM4001;
    @Value("${sudoc.passwdM4001}")
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
    public void authenticate(String login, String passwd) throws CBSException {
        this.clientBiblio.authenticate(serveurIp, serveurPort, login, passwd);
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
     * @param noticeStarXml la thèse en MarcXml Sudoc sous forme de String
     * @return le résultat de la création/modification de la thèse
     * @see fr.abes.cbs
     */
    @Override
    public NoticeBiblioDto majStarSudoc(String noticeStarXml, NoticeBiblioDto trace)  {
        try {
            NoticeConcrete notice = new NoticeConcrete(noticeStarXml);
            this.setNumSource(notice.getNoticeBiblio().findZones("002").get(0).findSousZone("$a").getValeur());
            this.setNumThese(notice.getNoticeBiblio().findZones("029").get(0).findSousZone("$b").getValeur());

            if (!noticeBiblioElecFinded(notice)) {
                creerTheseBiblio(notice, trace);
            } else {
                fusionNoticeStarEtSudoc(notice, trace);
            }
        } catch (CBSException ex) {
            log.error("Erreur dans la création de la notice bibliographique " + ex.getMessage());
        }
        return trace;
    }

    private boolean noticeBiblioElecFinded(NoticeConcrete notice) throws CBSException {
        //on cherche si la thèse STAR est dans le Sudoc en utilisant le numéro source (zone unimarc 002)
        clientBiblio.search("che sou " + getNumSource());
        if (clientBiblio.getNbNotices() == 0) {
            //pas de notice avec recherche sur le num. source donc on lance la recherche sur le num. de thèse (zone unimarc 029)
            clientBiblio.search("che num " + getNumThese());
            if (clientBiblio.getNbNotices() >= 1) {
                //quand la notice trouvée est une thèse papier, on doit créer la notice biblio electronique
                if (!notice.getNoticeBiblio().isTheseElectronique()) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Créer la notice biblio de la thèse venant de Star
     * On utilise la méthode EnregistrerNew de la classe Cbs à laquelle on passe en paramètre NoticeBiblio
     * Le ppn de la notice créée est dans PpnEncours de CBSclient
     *
     * @param noticeBiblio notice à créer
     * @return le message succès/échec de la création, le ppn structuré avec balise
     */
    @Override
    public void creerTheseBiblio(NoticeConcrete noticeBiblio, NoticeBiblioDto trace) {
        try {
            clientBiblio.enregistrerNew(noticeBiblio.toString());
            trace.setIndicSudoc("OK");
            trace.setPpn(clientBiblio.getPpnEncours());
            trace.setRetourSudoc("Notice biblio créée");
            trace.setDateCreation(new Date());
            trace.setDateModification(new Date());
        } catch (CBSException ex) {
            trace.setIndicSudoc("NOK - Notice non créée</CODERETOUR>");
            trace.setRetourSudoc(ex.getMessage());
        }
    }

    /**
     * Méthode de modification d'une notice biblio dans le Sudoc
     * @param theseStar
     * @return
     * @throws CBSException
     * @throws ExecutionControl.NotImplementedException
     */
    private void fusionNoticeStarEtSudoc(NoticeConcrete theseStar, NoticeBiblioDto trace) throws CBSException {
        clientBiblio.affUnma();
        String resu = clientBiblio.editer("1");
        Biblio noticeBiblio = new Biblio(resu.substring(resu.indexOf(Constants.STR_1F), resu.indexOf(Constants.STR_1E, resu.indexOf(Constants.STR_1F)) + 1));
        String fusion = fusionThese(theseStar.getNoticeBiblio(), noticeBiblio);
        try {
            clientBiblio.modifierNotice("1", fusion);
            //création notice biblio ok
            trace.setIndicSudoc("OK");
            trace.setPpn(clientBiblio.getPpnEncours());
            trace.setRetourSudoc("Notice biblio fusionnée");
            trace.setDateModification(new Date());
        } catch (Exception ex) {
            trace.setIndicSudoc("NOK");
            trace.setRetourSudoc(ex.getMessage());
        }

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

        String labelZonePrecedente = "";
        traitementPreliminaire(noticeSudoc, noticeStar);
        for (Zone zoneSudoc : noticeSudoc.getListeZones().values()){
                if (getDao().getZonePrioritaire().findZoneByLabel(zoneSudoc.getLabelForOutput()) == null) {
                    noticeFusionnee.addZone(zoneSudoc);
                } else {
                    List<Zone> zoneStar = noticeStar.findZones(zoneSudoc.getLabelForOutput());
                    if (zoneStar.isEmpty()) {
                        noticeFusionnee.addZone(zoneSudoc);
                    } else {
                        if (!zoneSudoc.getLabelForOutput().equals(labelZonePrecedente)){
                            for (Zone zoneAEcrire : zoneStar) {
                                noticeFusionnee.addZone(zoneAEcrire);
                            }
                            labelZonePrecedente = zoneSudoc.getLabelForOutput();
                        }
                    }
                }
        }

        noticeFusionnee = traitementSpecifique(noticeStar, noticeSudoc, noticeFusionnee);

        return noticeFusionnee.toString().substring(1, noticeFusionnee.toString().length()-1);
    }

    private void traitementPreliminaire(Biblio noticeSudoc, Biblio noticeStar) {
        noticeSudoc.deleteZone("702");
        noticeSudoc.deleteZone("712");
        noticeStar.deleteZone("702");
        noticeStar.deleteZone("712");
    }

    /**
     * Traitement spécifique permettant de transférer toutes les sous zones de la 219 vers une nouvelle zone 214 dans la notice fusionnée
     * @param noticeStar
     * @param noticeSudoc
     * @param noticeFusionnee
     * @return
     */
    private Biblio traitementSpecifique(Biblio noticeStar, Biblio noticeSudoc, Biblio noticeFusionnee) {
        traitement219(noticeStar, noticeFusionnee);
        traitementZoneStar(noticeStar, noticeSudoc, noticeFusionnee);
        return noticeFusionnee;
    }

    private void traitementZoneStar(Biblio noticeStar, Biblio noticeSudoc, Biblio noticeFusionnee) {
        String labelZonePrecedente = "";

        for(Zone zoneStar : noticeStar.getListeZones().values()){
            String labelZone = zoneStar.getLabelForOutput();
            if (noticeFusionnee.findZones(labelZone).isEmpty() && !labelZonePrecedente.equals(labelZone)){
                for( Zone zoneStarToAdd : noticeStar.findZones(labelZone)){
                    noticeFusionnee.addZone(zoneStarToAdd);
                }
                labelZonePrecedente = labelZone;
            }
        }
    }

    private void traitement219(Biblio noticeStar, Biblio noticeFusionnee) {
        List<Zone> zone219s = noticeStar.findZones("219");
        for (Zone zone219: zone219s) {
            List<SousZone> sousZones214 = new ArrayList<>();
            for (Zone_219 sousZone: EnumUtils.getEnumList(Zone_219.class)) {
                if (EnumUtils.isValidEnum(Zone_214.class, sousZone.name())) {
                    SousZone ssZone219 =  zone219.findSousZone(sousZone.name());
                    if (ssZone219 != null) {
                        sousZones214.add(new SousZone(Zone_214.valueOf(sousZone.name()), ssZone219.getValeur()));
                    }
                }
            }
            Zone zone214 = new Zone(EnumZones.Z214, sousZones214, zone219.getIndicateurs());
            noticeFusionnee.deleteZone("214");
            noticeFusionnee.addZone(zone214);
        }
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

    @Override
    public void disconnectBiblio() {
        log.info("Déconnexion du Sudoc login M4001");
        this.clientBiblio.disconnect();
    }
}

