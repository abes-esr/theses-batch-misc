package fr.abes.theses.service;

import fr.abes.theses.model.dto.NoticeBiblioDto;

public interface IGestionTefService {
    void majDonneesGestion(NoticeBiblioDto dto, Integer idDoc, String codeEtab);
}
