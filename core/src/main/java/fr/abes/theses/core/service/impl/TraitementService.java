package fr.abes.theses.core.service.impl;

import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.Traitement;
import fr.abes.theses.core.service.ITraitementService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementService implements ITraitementService {
    @Autowired @Getter
    private DaoProvider dao;

    @Override
    public List<Traitement> findAll() {
        return getDao().getTraitement().findAll();
    }

    @Override
    public Traitement save(Traitement traitement) {
        return getDao().getTraitement().save(traitement);
    }

    @Override
    public Traitement findById(Integer id) {
        Optional<Traitement> traitement = getDao().getTraitement().findById(id);
        if (traitement.isPresent()) {
            return traitement.get();
        }
        return null;
    }
}
