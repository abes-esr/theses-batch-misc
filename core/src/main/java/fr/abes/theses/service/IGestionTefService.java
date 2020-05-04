package fr.abes.theses.service;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import org.dom4j.DocumentException;

public interface IGestionTefService {

    void majDonneesGestion(NoticeBiblioDto dto) throws InstantiationException, DocumentException;
}
