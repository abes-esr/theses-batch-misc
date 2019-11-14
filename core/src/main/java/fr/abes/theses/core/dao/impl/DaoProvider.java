package fr.abes.theses.core.dao.impl;

import fr.abes.theses.core.dao.INoticeBiblioDao;
import fr.abes.theses.core.dao.ITraitementDao;
import fr.abes.theses.core.dao.ITraitementLigneDao;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoProvider {
    @Resource
    private ITraitementDao traitement;

    @Resource
    private ITraitementLigneDao traitementLigne;

    @Resource
    private INoticeBiblioDao noticeBiblio;
}
