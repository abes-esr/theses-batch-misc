package fr.abes.theses.service;

import fr.abes.theses.model.entities.Document;

import java.util.List;

public interface IDocumentService {
    List<Document> findAll();
    Document findById(Integer id);
}
