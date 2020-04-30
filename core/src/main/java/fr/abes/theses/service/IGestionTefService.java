package fr.abes.theses.service;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface IGestionTefService {

    void majDonneesGestionExemplarisation(NoticeBiblioDto noticeBiblioDto) throws InstantiationException, DocumentException, IOException, SAXException, ParserConfigurationException, TransformerException;

    void majDonneesGestion(NoticeBiblioDto dto) throws InstantiationException, DocumentException, TransformerException, IOException, SAXException, ParserConfigurationException;
}
