package fr.abes.theses.dao.impl;

import fr.abes.theses.dao.IDocumentDao;
import fr.abes.theses.dao.INoticeBiblioDao;
import fr.abes.theses.dao.IZonePrioritaireDao;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Getter
@Service
public class DaoProvider {
    @Resource
    private INoticeBiblioDao noticeBiblio;

    @Resource
    private IDocumentDao document;

    @Resource
    private IZonePrioritaireDao zonePrioritaire;
}
