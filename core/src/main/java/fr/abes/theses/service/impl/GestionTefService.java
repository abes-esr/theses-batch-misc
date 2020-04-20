package fr.abes.theses.service.impl;


import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.Tef;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.service.IGestionTefService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Slf4j
public class GestionTefService implements IGestionTefService {
    @Getter
    final
    DaoProvider dao;

    public GestionTefService(DaoProvider dao) {
        this.dao = dao;
    }

    @Override
    public void majDonneesGestionExemplarisation(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException {
        Document document = getDao().getDocument().findById(noticeBiblioDto.getIddoc()).orElse(null);
        if (document != null) {
            Tef tef = new Tef(document.getDoc());
            tef.setStarGestionAttributExemplaire(new Date(), noticeBiblioDto.getIndicSudoc(), noticeBiblioDto.getRetourSudoc());
            document.setDoc(tef.documentTef.asXML());
            getDao().getDocument().saveAndFlush(document);
        } else {
            log.error("These not found in Document table, id : " + noticeBiblioDto.getIddoc());
        }
    }

    @Override
    public void majDonneesGestion(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException {
        Document document = getDao().getDocument().findById(noticeBiblioDto.getIddoc()).orElse(null);
        if (document != null) {
            Tef documentTef = new Tef(document.getDoc());
            documentTef.setStarGestionAttribut(new Date(), noticeBiblioDto.getRetourSudoc(), noticeBiblioDto.getIndicSudoc(), noticeBiblioDto.getPpn());
            document.setDoc(documentTef.documentTef.asXML());
            getDao().getDocument().saveAndFlush(document);
        } else {
            log.error("These not found in Document table, id : " + noticeBiblioDto.getIddoc());
        }
    }

    private String getDateISO8601() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}

