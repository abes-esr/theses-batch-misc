package fr.abes.theses.dao;

import fr.abes.theses.model.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentDao extends JpaRepository<Document, Integer> {
}
