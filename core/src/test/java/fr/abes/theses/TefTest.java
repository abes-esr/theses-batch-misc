package fr.abes.theses;

import fr.abes.theses.model.Tef;
import fr.abes.theses.model.tefjaxb.Mets;
import fr.abes.theses.service.MarshallingService;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TefTest {

    @Test
    void tefTest(){
        String fileName = getClass().getClassLoader().getResource("tef.xml").getPath();

        Document doc;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(new File(fileName));
            Element root = doc.getRootElement();

            List<Element> empListElements = root.elements("metsHdr");
            var a = 0;
        } catch (Exception e)
        {
        }
    }

    @Test
    void tefTest2() throws Exception {

        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File fXmlFile = new File(filePath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(fXmlFile);
        Tef tef = new Tef(HibernateXMLType.domToString(doc));


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
