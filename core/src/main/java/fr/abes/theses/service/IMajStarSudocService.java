package fr.abes.theses.service;

import fr.abes.cbs.exception.CBSException;

public interface IMajStarSudocService {
    void authenticateBiblio() throws CBSException;

    String majStarSudoc(String marcXml) throws CBSException;

    String creerTheseBiblio(String noticeBiblio);

    String majTheseBiblio(String notice);

    String creerExpl(String exemplaire, String lePPN);
}
