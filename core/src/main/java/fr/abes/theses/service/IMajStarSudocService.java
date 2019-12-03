package fr.abes.theses.service;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.NoticeConcrete;
import jdk.jshell.spi.ExecutionControl;

public interface IMajStarSudocService {
    void authenticateBiblio() throws CBSException;

    String majStarSudoc(String marcXml) throws ExecutionControl.NotImplementedException;

    String creerTheseBiblio(NoticeConcrete noticeBiblio);

    String majTheseBiblio(String notice);

    String creerExpl(String exemplaire, String lePPN);
}
