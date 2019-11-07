package fr.abes.theses.core.dao;

import fr.abes.theses.core.model.entities.TraitementLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITraitementLigneDao extends JpaRepository<TraitementLigne, Integer> {
}
