package fr.abes.theses.core.service.impl;

import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.TraitementLigne;
import fr.abes.theses.core.service.ITraitementLigneService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementLigneService implements ITraitementLigneService {
    @Autowired @Getter
    private DaoProvider dao;

    @Override
    public List<TraitementLigne> findAll() {
        return getDao().getTraitementLigne().findAll();
    }

    @Override
    public TraitementLigne save(TraitementLigne traitementLigne) {
        return getDao().getTraitementLigne().save(traitementLigne);
    }

    @Override
    public TraitementLigne findById(Integer id) {
        Optional<TraitementLigne> traitementLigne = getDao().getTraitementLigne().findById(id);
        if (traitementLigne.isPresent()) {
            return traitementLigne.get();
        }
        return null;
    }
}
