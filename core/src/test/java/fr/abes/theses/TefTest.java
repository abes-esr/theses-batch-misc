package fr.abes.theses;

import fr.abes.theses.model.Tef;
import fr.abes.theses.model.tefjaxb.Mets;
import fr.abes.theses.service.MarshallingService;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class TefTest {



    @Test
    void tefTest2() throws Exception {

        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();

        SAXReader xmlReader = new SAXReader();
        Document document = xmlReader.read(filePath);

        Tef tef = new Tef(document.asXML());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = simpleDateFormat.format(new Date());

        tef.setStarGestionAttribut(LocalDateTime.now(), "retourSudoc", "indicSudoc", "5205");

        var a = 0;
    }

    @Test
    void tefTest3() throws Exception {
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();

        InputStream inputStream = new FileInputStream(filePath);

        Mets mets = new MarshallingService().chargerMets(inputStream);

        var a = 0;
    }

    @Test
    void updateDate() throws Exception {
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();

        SAXReader xmlReader = new SAXReader();
        Document document = xmlReader.read(filePath);

        Tef tef = new Tef(document.asXML());

        tef.setStarGestionAttribut(LocalDateTime.now(), "Notice créé", "OK", "");

        var str = tef.documentTef.asXML();
    }


}
