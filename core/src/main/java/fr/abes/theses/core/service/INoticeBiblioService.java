package fr.abes.theses.core.service;

import fr.abes.theses.core.model.entities.NoticeBiblio;

import java.util.List;

public interface INoticeBiblioService {

    List<NoticeBiblio> findAll();

    NoticeBiblio save(NoticeBiblio noticeBiblio);

    NoticeBiblio findById(Integer id);
}
