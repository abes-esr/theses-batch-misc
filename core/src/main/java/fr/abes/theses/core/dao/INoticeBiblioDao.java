package fr.abes.theses.core.dao;

import fr.abes.theses.core.model.entities.NoticeBiblio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoticeBiblioDao extends JpaRepository<NoticeBiblio, Integer> {
}
