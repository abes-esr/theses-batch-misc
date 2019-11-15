package fr.abes.theses.core.dao.impl;

import fr.abes.theses.core.dao.INoticeBiblioDao;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoProvider {
    @Resource
    private INoticeBiblioDao noticeBiblio;
}
