package fr.abes.theses.service.impl;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.*;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Slf4j
@Service
public class MajStarSudocService implements IMajStarSudocService {
    @Autowired
    @Getter
    private DaoProvider dao;

    @Getter
    private ProcessCBS clientBiblio;
    private ProcessCBS clientExpl;
    private ProcessCBS clientExemplSupp;

    @Value("${sudoc.serveur}")
    private String serveurIp;
    @Value("${sudoc.port}")
    private String serveurPort;

    @Value("${sudoc.loginM4001}")
    private String login;

    @Value("${sudoc.passwdM4001}")
    private String passwd;

    @Getter
    @Setter
    private String numSource;
    @Getter
    @Setter
    private String numThese;

    @Getter
    @Setter
    private String numThesePrecedent = "";

    /**
     * Permet de ne pas créer d'exemplaires, de rcr non déployé, en trop
     */
    @Setter
    @Getter
    private boolean premiereExemplarisationRcrNonDeploye;

    public MajStarSudocService() {
        this.clientBiblio = new ProcessCBS();
        this.clientExpl = new ProcessCBS();
        this.clientExemplSupp = new ProcessCBS();
        setPremiereExemplarisationRcrNonDeploye(true);
    }

    @Override
    public void authenticateBiblio(String login, String passwd) throws CBSException {
        this.clientBiblio.authenticate(serveurIp, serveurPort, login, passwd);
    }

    @Override
    public void authenticateExemp(String login, String passwd) throws CBSException {
        if (!login.substring(1).equals(this.clientExpl.getRcr())) {
            disconnectExemp();
            this.clientExpl.authenticate(serveurIp, serveurPort, login, passwd);
        }
    }

    public void authenticateExempSupp(String login, String passwd) throws CBSException {
        this.clientExemplSupp.authenticate(serveurIp, serveurPort, login, passwd);
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
    public NoticeBiblioDto majStarSudocBiblio(String noticeStarXml, NoticeBiblioDto trace) {
        try {
            NoticeConcrete notice = new NoticeConcrete(noticeStarXml);
            this.setNumSource(notice.getNoticeBiblio().findZones("002").get(0).findSousZone("$a").getValeur());
            this.setNumThese(notice.getNoticeBiblio().findZones("029").get(0).findSousZone("$b").getValeur());

            if (noticeBiblioElecFinded(notice)) {
                fusionNoticeStarEtSudoc(notice, trace);
            } else {
                creerTheseBiblio(notice, trace);
            }
        } catch (CBSException ex) {
            log.error("Erreur dans la création de la notice bibliographique " + ex.getMessage());
            trace.setIndicSudoc("KO");
            trace.setRetourSudoc(ex.getMessage());
        }
        trace.setDateModification(new Date());
        return trace;
    }

    private boolean noticeBiblioElecFinded(NoticeConcrete notice) throws CBSException {
        //on cherche si la thèse STAR est dans le Sudoc en utilisant le numéro source (zone unimarc 002)
        try {
            clientBiblio.search("che sou " + getNumSource());
            if (clientBiblio.getNbNotices() == 0) {
                //pas de notice avec recherche sur le num. source donc on lance la recherche sur le num. de thèse (zone unimarc 029)
                clientBiblio.search("che num " + getNumThese());
                if (clientBiblio.getNbNotices() >= 1) {
                    //quand la notice trouvée est une thèse papier, on doit créer la notice biblio electronique
                    if (!notice.getNoticeBiblio().isTheseElectronique()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            log.info("Erreur lors de la recherche de notice biblio electronique : " + getNumSource());
            log.info(e.getMessage());
            throw e;
        }
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
            clientBiblio.enregistrerNew(
                    noticeBiblio.toString().substring(noticeBiblio.toString().indexOf(Constants.STR_1F)+1, noticeBiblio.toString().indexOf(Constants.STR_1E))
            );
            trace.setIndicSudoc("OK");
            trace.setPpn(clientBiblio.getPpnEncours());
            trace.setRetourSudoc("Notice biblio créée");
        } catch (CBSException ex) {
            log.info(ex.getMessage());
            trace.setIndicSudoc("KO");
            trace.setRetourSudoc("Notice biblio non créée : " + ex.getMessage());
        }
    }

    /**
     * Méthode de modification d'une notice biblio dans le Sudoc
     *
     * @param theseStar
     * @return
     * @throws CBSException
     * @throws ExecutionControl.NotImplementedException
     */
    private void fusionNoticeStarEtSudoc(NoticeConcrete theseStar, NoticeBiblioDto trace) throws CBSException {
        clientBiblio.affUnma();
        String resu = clientBiblio.editer("1");
        try {
            Biblio noticeBiblio = new Biblio(resu.substring(resu.indexOf(Constants.STR_1F), resu.indexOf(Constants.STR_1E, resu.indexOf(Constants.STR_1F)) + 1));
            String fusion = fusionThese(theseStar.getNoticeBiblio(), noticeBiblio);

            clientBiblio.modifierNotice("1", fusion);
            //création notice biblio ok
            trace.setIndicSudoc("OK");
            trace.setPpn(clientBiblio.getPpnEncours());
            trace.setRetourSudoc("Notice biblio fusionnée");
            trace.setDateModification(new Date());
        } catch (Exception ex) {
            log.info("fusionNoticeStarEtSudoc " + ex.getMessage());
            trace.setIndicSudoc("KO");
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
        for (Zone zoneSudoc : noticeSudoc.getListeZones().values()) {
            if (getDao().getZonePrioritaire().findZoneByLabel(zoneSudoc.getLabelForOutput()) == null) {
                noticeFusionnee.addZone(zoneSudoc);
            } else {
                List<Zone> zoneStar = noticeStar.findZones(zoneSudoc.getLabelForOutput());
                if (zoneStar.isEmpty()) {
                    noticeFusionnee.addZone(zoneSudoc);
                } else {
                    if (!zoneSudoc.getLabelForOutput().equals(labelZonePrecedente)) {
                        for (Zone zoneAEcrire : zoneStar) {
                            noticeFusionnee.addZone(zoneAEcrire);
                        }
                        labelZonePrecedente = zoneSudoc.getLabelForOutput();
                    }
                }
            }
        }

        noticeFusionnee = traitementSpecifique(noticeStar, noticeSudoc, noticeFusionnee);

        return noticeFusionnee.toString().substring(1, noticeFusionnee.toString().length() - 1);
    }

    private void traitementPreliminaire(Biblio noticeSudoc, Biblio noticeStar) {
        noticeSudoc.deleteZone("702");
        noticeSudoc.deleteZone("712");
        noticeStar.deleteZone("702");
        noticeStar.deleteZone("712");
    }

    /**
     * Traitement spécifique permettant de transférer toutes les sous zones de la 219 vers une nouvelle zone 214 dans la notice fusionnée
     *
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

        for (Zone zoneStar : noticeStar.getListeZones().values()) {
            String labelZone = zoneStar.getLabelForOutput();
            if (noticeFusionnee.findZones(labelZone).isEmpty() && !labelZonePrecedente.equals(labelZone)) {
                for (Zone zoneStarToAdd : noticeStar.findZones(labelZone)) {
                    noticeFusionnee.addZone(zoneStarToAdd);
                }
                labelZonePrecedente = labelZone;
            }
        }
    }

    private void traitement219(Biblio noticeStar, Biblio noticeFusionnee) {
        List<Zone> zone219s = noticeStar.findZones("219");
        for (Zone zone219 : zone219s) {
            List<SousZone> sousZones214 = new ArrayList<>();
            for (Zone_219 sousZone : EnumUtils.getEnumList(Zone_219.class)) {
                if (EnumUtils.isValidEnum(Zone_214.class, sousZone.name())) {
                    SousZone ssZone219 = zone219.findSousZone(sousZone.name());
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

    @Override
    public NoticeBiblioDto majStarSudocExemp(String noticeStarXml, NoticeBiblioDto trace, boolean premiereExemplarisationRcrNonDeploye) throws CBSException {
        NoticeConcrete notice = new NoticeConcrete(noticeStarXml);
        String idStar = notice.getNoticeBiblio().findZone("002", 0).findSousZone("$a").getValeur();
        List<Zone> e856 = findE856IntoXml(noticeStarXml);

        try {
            if (!getNumThesePrecedent().equals(idStar)) {
                supprimerExemplaireGenereParStarDansSudoc(idStar);
            }
            setNumThesePrecedent(idStar);
            rediffuserExemplaireStarDansSudoc(trace, notice, e856, premiereExemplarisationRcrNonDeploye, idStar);
        } catch (CBSException e) {
            trace.setRetourSudoc(e.getMessage());
            trace.setIndicSudoc("KO");
        } catch (IllegalStateException e) {
            trace.setRetourSudoc(e.getMessage());
            trace.setIndicSudoc("KO");
        }


        return trace;
    }


    private void rediffuserExemplaireStarDansSudoc(NoticeBiblioDto trace, NoticeConcrete notice, List<Zone> e856s, boolean premiereExemplarisationRcrNonDeploye, String idStar) throws CBSException {

        this.clientExpl.search("che sou " + idStar);
        clientExpl.editer("1");
        for (Exemplaire exemplaire : notice.getExemplaires()) {

            String numExemplaireCurrent = clientExpl.getNvNumEx() == null ? "01" : clientExpl.getNvNumEx().substring(1);

            exemplaire.addZone("e" + numExemplaireCurrent, "$b", "x");
            exemplaire.addZone("991", "$a", "exemplaire créé automatiquement par STAR");

            for (Zone e856 : e856s) {
                exemplaire.addZone(e856);
            }

            if (estExemplaireDuRcr(exemplaire, trace, premiereExemplarisationRcrNonDeploye)) {
                try {
                    this.clientExpl.creerExemplaire(numExemplaireCurrent);
                    String exempToWrite = exemplaire.toString().substring(1, exemplaire.toString().length() - 1);
                    this.clientExpl.newExemplaire(exempToWrite);
                    String resultatCreation = this.clientExpl.editer("1");
                    List<Exemplaire> exemplairesCree = NoticeConcrete.listeExemplaireUnimarc(resultatCreation);
                    Exemplaire exemplaireCree = exemplairesCree.stream().filter(e -> e.getNumEx().equals(numExemplaireCurrent)).findFirst().orElse(null);

                    if (exemplaireCree != null) {
                        String ePN = exemplaireCree.findZone("A99", 0).getValeur();
                        trace.setEpn(ePN);
                        trace.setIndicSudoc("OK");
                        trace.setRetourSudoc("Exemplaire créé");
                    } else {
                        trace.setRetourSudoc("Exemplaire non créé");
                        trace.setIndicSudoc("KO");
                    }

                } catch (CBSException e) {
                    trace.setRetourSudoc(e.getMessage());
                    trace.setIndicSudoc("KO");
                }
            }
        }
    }

    private boolean estExemplaireDuRcr(Exemplaire exemplaire, NoticeBiblioDto trace, boolean premiereExemplarisationRcrNonDeploye) throws CBSException {
        String rcrExemplaire = exemplaire.findZone("930", 0).findSousZone("$b").getValeur();
        if (rcrExemplaire.equals(trace.getCodeEtab())) {
            return true;
        } else {
            if (Integer.parseInt(this.clientExpl.ilnRattachement(rcrExemplaire)) > 199
                    && Integer.parseInt(this.clientExpl.ilnRattachement(rcrExemplaire)) <= 300 && premiereExemplarisationRcrNonDeploye) {
                return true;
            } else {
                return false;
            }
        }
    }

    private void supprimerExemplaireGenereParStarDansSudoc(String idStar) throws CBSException {
        this.clientExpl.search("che sou " + idStar);
        if (this.clientExpl.getNbNotices() == 1) {

            String resu = this.clientExpl.affUnma();
            List<Exemplaire> exemplaires = new ArrayList<>();

            String regex = "<BR>(?<numEx>e\\d{2}).*?<BR>A98 (?<rcr>\\d*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(resu);


            while (matcher.find()) {
                Exemplaire exemplaire = new Exemplaire();
                exemplaire.addZone(matcher.group("numEx"), "$bx");
                if (matcher.group(0).contains("exemplaire créé automatiquement par")) {
                    exemplaire.addZone("991", "$a", "exemplaire créé automatiquement par STAR", new char[]{'#', '#'});
                }
                exemplaire.addZone("A98", matcher.group("rcr") + ":");
                exemplaires.add(exemplaire);
            }

            try {
                for (Exemplaire exemplaire : exemplaires) {
                    if (estCreeAutomatiquementParStar(exemplaire)) {
                        String a98 = exemplaire.findZone("A98", 0).getValeur();
                        String rcrExemplaire = a98.split(":")[0];
                        authenticateExempSupp("M" + rcrExemplaire, passwd);
                        clientExemplSupp.search("che sou " + idStar);
                        clientExemplSupp.supExemplaire(exemplaire.getNumEx());
                        clientExemplSupp.disconnect();
                    }
                }
            } catch (Exception e) {
                clientExemplSupp.disconnect();
                throw e;
            }
        } else {
            if (this.clientExpl.getNbNotices() > 1) {
                throw new IllegalStateException("Plusieurs notice pour l'ID star " + idStar);
            } else {
                throw new IllegalStateException("Pas de notice pour l'ID star " + idStar);
            }
        }

    }

    private boolean procesCbsPeutModifierExemplaire(ProcessCBS clientExpl, Exemplaire exemplaire) {
        String a98 = exemplaire.findZone("A98", 0).getValeur();
        String rcrExemplaire = a98.split(":")[0];

        return rcrExemplaire.equals(clientExpl.getRcr());
    }

    private boolean estCreeAutomatiquementParStar(Exemplaire exemplaire) {
        List<Zone> zones = exemplaire.findZoneWithPattern("991", "$a", "exemplaire créé automatiquement par");
        return !zones.isEmpty();
    }

    private List<Zone> findE856IntoXml(String noticeStarXml) {

        final String regex = "(<datafield tag=\"E856\".+?<\\/datafield>)";
        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(noticeStarXml);

        List<Zone> zoneE856s = new ArrayList<>();

        while (matcher.find()) {
                NodeList childNodesE856 = convertStringToDocument(matcher.group(0)).getChildNodes();
                Node tag = childNodesE856.item(0);

                Zone zoneE856 = new Zone(EnumZones.E856, Notice.getIndicateurs(tag));

                for (int i = 0; i < tag.getChildNodes().getLength(); i++) {
                    if ("subfield".equals(tag.getChildNodes().item(i).getNodeName())) {
                        zoneE856.ajoutSousZone("$" + tag.getChildNodes().item(i).getAttributes().getNamedItem("code").getTextContent(),
                                tag.getChildNodes().item(i).getTextContent());
                    }
                }
                zoneE856s.add(zoneE856);
        }
        return zoneE856s;
    }

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlStr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
     * @param nnt        le nnt de la notice biblio
     * @return le message succès/échec de la création et l'epn structuré avec balise
     */
    @Override
    public String creerExpl(Exemplaire exemplaire, String nnt, NoticeBiblioDto trace) {
        StringBuilder resultCat = new StringBuilder();
        String resu;
        try {
            clientExpl.search("che nnt " + nnt);
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

    @Override
    public void disconnectExemp() {
        if (this.clientExpl.getClientCBS().isConnected()) {
            log.info("Déconnexion du client exemplarisation");
            this.clientExpl.disconnect();
        } else {
            log.info("Client exemplarisation déjà déconnecté");
        }
    }

    @Override
    public boolean getPremiereExemplarisationRcrNonDeploye() {
        return premiereExemplarisationRcrNonDeploye;
    }
}

