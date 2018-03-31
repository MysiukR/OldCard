package com.epam.lab.XMLParser;

import com.epam.lab.Model.Constants;
import com.epam.lab.Model.OldCard;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParserStAX {

    public void outputResults() {
        String fileName = Constants.pathToXML;
        List<OldCard> oldCardList = parseXML(fileName);
        for (OldCard emp : oldCardList) {
            System.out.println(emp.toString());
        }
        System.out.println();
    }

    private List<OldCard> parseXML(String fileName) {
        List<OldCard> oldCardList = new ArrayList();
        OldCard oldCard = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(fis);
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("oldCard")) {
                        oldCard = new OldCard();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            oldCard.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("theme")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setTheme(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("cardType")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setCardType(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("status")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setStatus(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("country")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setCountry(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("year")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setYear(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("author")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setAuthor(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("valuable")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        oldCard.setValuable(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("oldCard")) {
                        oldCardList.add(oldCard);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oldCardList;
    }
}