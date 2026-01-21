package fr.abes.theses.service.impl;

import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.service.IDocumentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    @Getter
    private DaoProvider dao;

    @Override
    public List<Document> findAll() {
        return getDao().getDocument().findAll();
    }

    @Override
    public Document findById(Integer id) {
        return getDao().getDocument().findById(id).orElse(null);
    }

    @Override
    public List<Integer> getIdDocAEnvoyerAuSudoc(String niveau, Integer maxResult) {
        return getDao().getDocumentEnvoiSudoc().findAllByNiveau(niveau, Pageable.ofSize(maxResult)).stream().map(a -> a.getIddoc()).collect(Collectors.toList());
    }

    public void deleteByIddocDeDocumentEnvoiSudoc(Integer iddoc, String niveau) {
        dao.getDocumentEnvoiSudoc().deleteAllByIddocAndNiveau(iddoc, niveau);
    }
    public void deleteByIddocDeDocumentEnvoiSudoc(List<Integer> ids, String niveau) {
        dao.getDocumentEnvoiSudoc().deleteAllByIddocInAndNiveau(ids, niveau);
    }


}
