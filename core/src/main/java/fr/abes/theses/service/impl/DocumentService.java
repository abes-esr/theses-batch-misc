package fr.abes.theses.service.impl;

import fr.abes.theses.service.IDocumentService;
import fr.abes.theses.thesesAccessLayer.dao.impl.DaoStarProvider;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    @Getter
    private DaoStarProvider dao;

    @Override
    public List<DocumentStar> findAll() {
        return getDao().getDocument().findAll();
    }

    @Override
    public DocumentStar findById(Integer id) {
        return getDao().getDocument().findById(id).orElse(null);
    }
}
