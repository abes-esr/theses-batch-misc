package fr.abes.theses.dao;

import fr.abes.theses.model.entities.NoticeBiblio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INoticeBiblioDao extends JpaRepository<NoticeBiblio, Integer> {
}
