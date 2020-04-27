package fr.abes.theses.utils;

import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class Utilitaire {

    public static String getMarcXmlFromTef(DocumentStar doc, String cheminXslTef2Marc, String fichierXslTef2Marc) throws TransformerException {

        try {
            Source stylesheet = new StreamSource(new File(cheminXslTef2Marc + fichierXslTef2Marc));
            StreamSource stream = new StreamSource(new StringReader(HibernateXMLType.domToString(doc.getDoc())));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(stylesheet);
            final StringWriter writer = new StringWriter();
            final StreamResult output = new StreamResult(writer);
            transformer.transform(stream, output);
            return writer.toString();
        } catch (TransformerException e) {
            throw e;
        }
    }

}
