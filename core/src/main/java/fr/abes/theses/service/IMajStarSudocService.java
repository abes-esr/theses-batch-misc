package fr.abes.theses.service;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.NoticeConcrete;
import fr.abes.theses.model.dto.NoticeBiblioDto;

public interface IMajStarSudocService {
    void authenticateBiblio() throws CBSException;

    void disconnectBiblio();

    NoticeBiblioDto majStarSudoc(String marcXml, NoticeBiblioDto noticeBiblioDto);

    void creerTheseBiblio(NoticeConcrete noticeBiblio, NoticeBiblioDto trace);

    String creerExpl(String exemplaire, String lePPN);
}
