package fr.abes.theses.service.impl;

import fr.abes.theses.service.INoticeBiblioService;
import fr.abes.theses.thesesAccessLayer.dao.impl.DaoStarProvider;
import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeBiblioService implements INoticeBiblioService {
    @Autowired
    @Getter
    private DaoStarProvider dao;

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

    @Override
    public List<NoticeBiblio> getNoticesNonTraiteByJobId(Integer idJob) {
        return getDao().getNoticeBiblio().getNoticesNonTraiteByJobId(idJob);
    }

    @Override
    public List<NoticeBiblio> getAllNoticesByJobId(Integer idJob) {
        return getDao().getNoticeBiblio().getAllNoticesByJobId(idJob);
    }
}
