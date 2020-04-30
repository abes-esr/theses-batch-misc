package fr.abes.theses.service.impl;

import fr.abes.theses.model.Tef;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.service.IGestionTefService;
import fr.abes.theses.thesesAccessLayer.dao.impl.DaoStarProvider;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Slf4j
public class GestionTefService implements IGestionTefService {
    @Getter
    final
    DaoStarProvider dao;

    public GestionTefService(DaoStarProvider dao) {
        this.dao = dao;
    }

    @Override
    public void majDonneesGestionExemplarisation(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException, IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentStar document = getDao().getDocument().findById(noticeBiblioDto.getIddoc()).orElse(null);
        if (document != null) {
            Tef tef = new Tef(HibernateXMLType.domToString(document.getDoc()));
            tef.setStarGestionAttributExemplaire(new Date(), noticeBiblioDto.getIndicSudoc(), noticeBiblioDto.getRetourSudoc());
            document.setDoc(HibernateXMLType.stringToDom(tef.documentTef.asXML()));
            getDao().getDocument().saveAndFlush(document);
        } else {
            log.error("These not found in Document table, id : " + noticeBiblioDto.getIddoc());
        }
    }

    @Override
    public void majDonneesGestion(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException, TransformerException, IOException, SAXException, ParserConfigurationException {
        DocumentStar document = getDao().getDocument().findById(noticeBiblioDto.getIddoc()).orElse(null);
        if (document != null) {
            Tef documentTef = new Tef(HibernateXMLType.domToString(document.getDoc()));
            documentTef.setStarGestionAttribut(new Date(), noticeBiblioDto.getRetourSudoc(), noticeBiblioDto.getIndicSudoc(), noticeBiblioDto.getPpn());
            document.setDoc(HibernateXMLType.stringToDom(documentTef.documentTef.asXML()));
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

