package fr.abes.theses.core.service;

import fr.abes.cbs.exception.CBSException;

public interface IMajStarSudocService {
    void authenticateBiblio() throws CBSException;

    String majStarSudoc(String marcXml, String xslStar);

    String creerTheseBiblio(String noticeBiblio);

    String majTheseBiblio(String notice);

    String creerExpl(String exemplaire, String lePPN);
}
