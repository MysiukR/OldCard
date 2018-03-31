package com.epam.lab.XMLParser;


import com.epam.lab.Model.Constants;
import com.epam.lab.Model.OldCard;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLParserDOM {
    private void showList(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("oldCard");
        List<OldCard> empList = new ArrayList<OldCard>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            empList.add(getOldCard(nodeList.item(i)));
        }
        for (OldCard oldCard : empList) {
            System.out.println(oldCard.toString());
        }
        System.out.println();
    }

    public void outputResults() {
        String filePath = Constants.pathToXML;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            showList(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    private static OldCard getOldCard(Node node) {
        OldCard oldCard = new OldCard();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            oldCard.setId(Integer.parseInt(element.getAttribute("id")));
            oldCard.setTheme(getTagValue("theme", element));
            oldCard.setCardType(getTagValue("cardType", element));
            oldCard.setStatus(getTagValue("status", element));
            oldCard.setCountry(getTagValue("country", element));
            oldCard.setAuthor(getTagValue("author", element));
            oldCard.setYear(getTagValue("year", element));
            oldCard.setValuable(getTagValue("valuable", element));
        }
        return oldCard;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}