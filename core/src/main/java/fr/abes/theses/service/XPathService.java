package fr.abes.theses.service;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
public class XPathService {

    public static final String XPATH_STAR_GESTION = "/mets:mets/mets:dmdSec/mets:mdWrap/mets:xmlData/star_gestion";
    public static final String XPATH_STAR_GEST_TRTS_SORTIES_SUDOC = XPATH_STAR_GESTION + "/traitements/sorties/sudoc";


    public static void setAttribut(String xpath, String attribut, String valeur, Document document) {
        try {
            // A précompiler a la création de la class
            XPath path = DocumentHelper.createXPath(xpath);
            List<Node> nodes = path.selectNodes(document);
            Element elem = (Element) nodes.get(0);
            if (elem != null && elem.attribute(attribut) != null) {
                elem.attribute(attribut).setValue(valeur);
            }
        } catch (Exception e) {
            log.error("Erreur générique dans setAttribut pour le xpath : " + xpath + " et attribut : " + attribut
                    + " et valeur : " + valeur, e);
            throw e;
        }
    }

    public static String getAttribut(String xpath, String attribut, Document document) {
        XPath path = DocumentHelper.createXPath(xpath);
        Element elem = (Element) path.selectNodes(document).get(0);
        return elem.attribute(attribut).getValue();
    }

    public static String getValue(String xpath, Document document) {
        XPath path = DocumentHelper.createXPath(xpath);
        Element elem = (Element) path.selectNodes(document).get(0);
        return elem.getText();
    }
}
