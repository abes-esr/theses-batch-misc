package fr.abes.theses;

import fr.abes.theses.model.Tef;
import fr.abes.theses.model.tefjaxb.Mets;
import fr.abes.theses.service.MarshallingService;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


public class TefTest {

    @Test
    void tefTest(){
        String fileName = getClass().getClassLoader().getResource("tef.xml").getPath();

        org.jdom2.Document jdomDoc;
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            jdomDoc = saxBuilder.build(new File(fileName));
            Element root = jdomDoc.getRootElement();

            //root.getChildren().get(0).setName("toto");

            List<Element> empListElements = root.getChildren("metsHdr", Namespace.getNamespace("http://www.loc.gov/METS/"));
            var a = 0;
        } catch (Exception e)
        {
        }
    }

    @Test
    void tefTest2() throws Exception {

        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();

        SAXReader xmlReader = new SAXReader();
        Document document = xmlReader.read(filePath);

        Tef tef = new Tef(document.asXML());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = simpleDateFormat.format(new Date());

        tef.setStarGestionAttribut(new Date(), "retourSudoc", "indicSudoc", "5205");

        var a = 0;
    }

    @Test
    void tefTest3() throws Exception {
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();

        InputStream inputStream = new FileInputStream(filePath);

        Mets mets = new MarshallingService().chargerMets(inputStream);

        var a= 0;
    }


}
