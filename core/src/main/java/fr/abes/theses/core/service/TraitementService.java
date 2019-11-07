package fr.abes.theses.core.service;

import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.Traitement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementService {
    @Autowired @Getter
    private DaoProvider dao;

    List<Traitement> findAll() {
        return getDao().getTraitement().findAll();
    }

    Traitement save(Traitement traitement) {
        return getDao().getTraitement().save(traitement);
    }

    Traitement findById(Integer id) {
        Optional<Traitement> traitement = getDao().getTraitement().findById(id);
        if (traitement.isPresent()) {
            return traitement.get();
        }
        return null;
    }
}
