package fr.abes.theses.service.impl;

import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.INoticeBiblioService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        return noticeBiblio.orElse(null);
    }
}
