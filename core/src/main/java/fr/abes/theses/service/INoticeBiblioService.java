package fr.abes.theses.service;

import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;

import java.util.List;

public interface INoticeBiblioService {

    List<NoticeBiblio> findAll();

    NoticeBiblio save(NoticeBiblio noticeBiblio);

    NoticeBiblio findById(Integer id);

    List<NoticeBiblio> getNoticesNonTraiteByJobId(Integer jobId);

    List<NoticeBiblio> getAllNoticesByJobId(Integer idJob);
}
