package com.epam.lab.XMLParser;

import com.epam.lab.Model.OldCard;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class MyHandler extends DefaultHandler {

    private List<OldCard> oldCardList = null;
    private OldCard oldcard = null;

    public List<OldCard> getOldCardList() {
        return oldCardList;
    }

    boolean bTheme = false;
    boolean bType = false;
    boolean bStatus = false;
    boolean bCountry = false;
    boolean bAuthor = false;
    boolean bYear = false;
    boolean bValuable = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("OldCard")) {
            String id = attributes.getValue("id");
            oldcard = new OldCard();
            oldcard.setId(Integer.parseInt(id));
            if (oldCardList == null)
                oldCardList = new ArrayList();
        } else if (qName.equalsIgnoreCase("theme")) {
            bTheme = true;
        } else if (qName.equalsIgnoreCase("cardType")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("status")) {
            bStatus = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
        } else if (qName.equalsIgnoreCase("year")) {
            bYear = true;
        } else if (qName.equalsIgnoreCase("valuable")) {
            bValuable = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("OldCard")) {
            oldCardList.add(oldcard);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bTheme) {
            oldcard.setTheme(new String(ch, start, length));
            bTheme = false;
        } else if (bType) {
            oldcard.setCardType(new String(ch, start, length));
            bType = false;
        } else if (bStatus) {
            oldcard.setStatus(new String(ch, start, length));
            bStatus = false;
        } else if (bCountry) {
            oldcard.setCountry(new String(ch, start, length));
            bCountry = false;
        } else if (bAuthor) {
            oldcard.setAuthor(new String(ch, start, length));
            bAuthor = false;
        } else if (bYear) {
            oldcard.setYear(new String(ch, start, length));
            bYear = false;
        } else if (bValuable) {
            oldcard.setValuable(new String(ch, start, length));
            bValuable = false;
        }
    }
}