package fr.abes.theses.service.impl;


import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.Tef;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.service.IGestionTefService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GestionTefService implements IGestionTefService {
    @Autowired @Getter
    DaoProvider dao;

    @Override
    public void majDonneesGestion(NoticeBiblioDto dto, Integer idDoc, String codeEtab) {
        Document document = getDao().getDocument().findById(idDoc).orElse(null);
        Tef documentTef = new Tef(document.getDoc());
        //TODO mise à jour des champs concernés
        document.setDoc(documentTef.toString());
        getDao().getDocument().save(document);

    }
}

