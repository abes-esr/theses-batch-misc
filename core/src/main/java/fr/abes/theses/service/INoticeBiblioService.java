package fr.abes.theses.service;

import fr.abes.theses.model.entities.NoticeBiblio;

import java.util.List;

public interface INoticeBiblioService {

    List<NoticeBiblio> findAll();

    NoticeBiblio save(NoticeBiblio noticeBiblio);

    NoticeBiblio findById(Integer id);

    List<NoticeBiblio> getNoticesNonTraiteByJobId(Integer jobId);

    List<String> getCodeEtabNonTraiteByJobId(Integer idJob);
}
