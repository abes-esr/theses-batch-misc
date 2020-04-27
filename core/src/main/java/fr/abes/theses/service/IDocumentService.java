package fr.abes.theses.service;

import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;

import java.util.List;

public interface IDocumentService {
    List<DocumentStar> findAll();
    DocumentStar findById(Integer id);
}
