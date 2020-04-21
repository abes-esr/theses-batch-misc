package fr.abes.theses.model;

import fr.abes.theses.service.XPathService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Date;

import static fr.abes.theses.service.XPathService.*;

@Slf4j
public class Tef {

    private static final String ERROR_MSG_EMPTY_TEF = "Erreur : le champ documentTef dans MajDonneesGestionTef est null.";

    public Document documentTef = null;


    public Tef(String document) throws DocumentException, InstantiationException {
        documentTef = DocumentHelper.parseText(document);
        checkDocumenTef();
    }


    public void setStarGestionAttribut(LocalDateTime dateModification, String retourSudoc, String indicSudoc, String ppn) throws InstantiationException {
        checkDocumenTef();

        try {
            if (isLongerThan3Minutes(dateModification)) {
                setIndicSudoc(indicSudoc);
                setPpn(ppn);
                setTrace(retourSudoc, indicSudoc);
            } else {
                if ("OK".equals(getIndicSudoc())) {
                    setIndicSudoc(indicSudoc);
                    setTrace(retourSudoc, indicSudoc);
                    setPpn(ppn);
                } else {
                    if ("KO".equals(indicSudoc)) {
                        String previousTrace = getTrace();
                        setTrace(previousTrace + ". " + retourSudoc);
                        setPpn(ppn);
                    }
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            setDate(formater.format(dateModification));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private String getTrace() {
        return XPathService.getAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "trace", documentTef);
    }

    private String getIndicSudoc() {
        return XPathService.getAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "indicSudoc", documentTef);
    }


    private boolean isLongerThan3Minutes(LocalDateTime toUpdate) {
        Duration diff = getPeridDiff(toUpdate, getDateInTef());
        Duration duration3Minute = Duration.ZERO.plusMinutes(3);
        return diff.toMinutes() > duration3Minute.toMinutes();
    }

    private Duration getPeridDiff(LocalDateTime firstDate, LocalDateTime secondDate) {
        return Duration.between(secondDate, firstDate);
    }

    private LocalDateTime getDateInTef() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime majSudoc = LocalDateTime.parse(XPathService.getAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "majSudoc", documentTef), formater);
        LocalDateTime dateSudoc = LocalDateTime.parse(XPathService.getAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "dateSudoc", documentTef), formater);
        if (majSudoc.isAfter(dateSudoc)) {
            return majSudoc;
        } else {
            return dateSudoc;
        }
    }

    private void setIndicSudoc(String indicSudoc) {
        XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "indicSudoc", indicSudoc, documentTef);
    }

    private void setTrace(String trace, String indicSudoc) {
        if ("KO".equals(indicSudoc)) {
            XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "trace", trace, documentTef);
        } else {
            XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "trace", "", documentTef);
        }
    }

    private void setTrace(String trace) {
        XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "trace", trace, documentTef);
    }

    private void setDate(String date) {
        String dateSudoc = XPathService.getAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "dateSudoc", documentTef);
        if (dateSudoc != null && !dateSudoc.isEmpty()) {
            XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "majSudoc", date, documentTef);
        } else {
            XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "dateSudoc", date, documentTef);
        }
    }

    private void setPpn(String ppn) {
        XPathService.setAttribut(XPATH_STAR_GEST_TRTS_SORTIES_SUDOC, "PPN", ppn, documentTef);
    }


    private void checkDocumenTef() throws InstantiationException {
        if (documentTef == null) {
            log.error(ERROR_MSG_EMPTY_TEF);
            throw new InstantiationException("DocumentTef n'est pas initalisé");
        }
    }

}
