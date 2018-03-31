package com.epam.lab.XMLParser;

import com.epam.lab.Model.Constants;
import com.epam.lab.Model.OldCard;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLParserSAX {

    public void outputResults() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(Constants.pathToXML), handler);
            List<OldCard> empList = handler.getOldCardList();
            for (OldCard oldCard : empList)
                System.out.println(oldCard);
            System.out.println();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

