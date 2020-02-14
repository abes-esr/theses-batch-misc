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
    @Autowired @Getter
    DaoProvider dao;

    @Override
    public void majTraitementSortieSudoc(NoticeBiblioDto noticeBiblioDto, Integer idDoc, String codeEtab) throws InstantiationException, DocumentException {
        Document document = getDao().getDocument().findById(idDoc).orElse(null);

        org.dom4j.Document retour = null;
        if (document != null) {
            Tef tef = new Tef(document.getDoc());
            tef.setStarGestionAttribut(getDateISO8601(), retour);
            getDao().getDocument().save(document);
        }
    }

    @Override
    public void majDonneesGestionExplenparisation(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException {
        Document document = getDao().getDocument().findById(noticeBiblioDto.getIddoc()).orElse(null);
        Tef tef = new Tef(document.getDoc());
        tef.setStarGestionAttributExemplaire(new Date(), noticeBiblioDto.getIndicSudoc(), noticeBiblioDto.getRetourSudoc());
        getDao().getDocument().save(document);
    }

    @Override
    public void majDonneesGestion(NoticeBiblioDto dto) throws InstantiationException, DocumentException {
        Document document = getDao().getDocument().findById(dto.getId()).orElse(null);
        Tef documentTef = new Tef(document.getDoc());
        documentTef.setStarGestionAttribut(dto.getDateCreation(), dto.getDateModification(), dto.getRetourSudoc(), dto.getIndicSudoc(), dto.getPpn());
        document.setDoc(documentTef.toString());
        getDao().getDocument().save(document);

    }

    private String getDateISO8601() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}

