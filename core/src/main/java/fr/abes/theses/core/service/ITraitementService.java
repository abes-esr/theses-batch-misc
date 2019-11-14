package fr.abes.theses.core.service;

import fr.abes.theses.core.model.entities.Traitement;

import java.util.List;

public interface ITraitementService {
    List<Traitement> findAll();

    Traitement save(Traitement traitement);

    Traitement findById(Integer id);
}
