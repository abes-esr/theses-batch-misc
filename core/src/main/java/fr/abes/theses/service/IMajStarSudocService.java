package fr.abes.theses.service;

import fr.abes.cbs.exception.CBSException;
import fr.abes.cbs.notices.Exemplaire;
import fr.abes.cbs.notices.NoticeConcrete;
import fr.abes.cbs.process.ProcessCBS;
import fr.abes.theses.model.dto.NoticeBiblioDto;

public interface IMajStarSudocService {
    ProcessCBS getClientBiblio();

    void authenticateBiblio(String login, String passwd) throws CBSException;

    void authenticateExemp(String login, String passwd) throws CBSException;

    void disconnectBiblio();

    NoticeBiblioDto majStarSudocBiblio(String marcXml, NoticeBiblioDto noticeBiblioDto);

    NoticeBiblioDto majStarSudocExemp(String marcXml, NoticeBiblioDto noticeBiblioDto, boolean premiereExemplarisationRcrNonDeploye) throws CBSException;

    void creerTheseBiblio(NoticeConcrete noticeBiblio, NoticeBiblioDto trace);

    String creerExpl(Exemplaire exemplaire, String lePPN, NoticeBiblioDto trace);

    void disconnectExemp();
}
