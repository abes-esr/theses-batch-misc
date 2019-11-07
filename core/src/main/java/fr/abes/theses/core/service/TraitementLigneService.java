package fr.abes.theses.core.service;

import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.TraitementLigne;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementLigneService {
    @Autowired @Getter
    private DaoProvider dao;

    public List<TraitementLigne> findAll() {
        return getDao().getTraitementLigne().findAll();
    }

    public TraitementLigne save(TraitementLigne traitementLigne) {
        return getDao().getTraitementLigne().save(traitementLigne);
    }

    public TraitementLigne findById(Integer id) {
        Optional<TraitementLigne> traitementLigne = getDao().getTraitementLigne().findById(id);
        if (traitementLigne.isPresent()) {
            return traitementLigne.get();
        }
        return null;
    }
}
