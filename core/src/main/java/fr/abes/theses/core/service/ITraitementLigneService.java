package fr.abes.theses.core.service;

import fr.abes.theses.core.model.entities.TraitementLigne;

import java.util.List;

public interface ITraitementLigneService {
    List<TraitementLigne> findAll();

    TraitementLigne save(TraitementLigne traitementLigne);

    TraitementLigne findById(Integer id);
}
