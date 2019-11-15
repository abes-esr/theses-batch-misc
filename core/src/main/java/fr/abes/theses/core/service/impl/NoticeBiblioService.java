package fr.abes.theses.core.service.impl;

import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.NoticeBiblio;
import fr.abes.theses.core.service.INoticeBiblioService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NoticeBiblioService implements INoticeBiblioService {


    @Autowired
    @Getter
    private DaoProvider dao;

    @Override
    public List<NoticeBiblio> findAll() {
        return getDao().getNoticeBiblio().findAll();
    }

    @Override
    public NoticeBiblio save(NoticeBiblio noticeBiblio) {
        return getDao().getNoticeBiblio().save(noticeBiblio);
    }

    @Override
    public NoticeBiblio findById(Integer id) {
        Optional<NoticeBiblio> noticeBiblio = getDao().getNoticeBiblio().findById(id);
        if (noticeBiblio.isPresent()) {
            return noticeBiblio.get();
        }
        return null;
    }
}
