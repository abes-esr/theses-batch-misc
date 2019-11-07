package fr.abes.theses.core.dao;

import fr.abes.theses.core.model.entities.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITraitementDao extends JpaRepository<Traitement, Integer> {
}
