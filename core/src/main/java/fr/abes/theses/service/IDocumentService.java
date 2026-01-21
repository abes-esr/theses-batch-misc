package fr.abes.theses.service;

import fr.abes.theses.model.entities.Document;

import java.util.List;

public interface IDocumentService {
    List<Document> findAll();
    Document findById(Integer id);
    List<Integer> getIdDocAEnvoyerAuSudoc(String niveau, Integer maxResult);
    void deleteByIddocDeDocumentEnvoiSudoc(Integer idDoc, String niveau);
    void deleteByIddocDeDocumentEnvoiSudoc(List<Integer> ids, String niveau);
}
