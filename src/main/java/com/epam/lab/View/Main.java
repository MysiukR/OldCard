package com.epam.lab.View;

import com.epam.lab.Model.OldCard;
import com.epam.lab.XMLConvert.ConvertToHTML;
import com.epam.lab.XMLConvert.ConvertXML;
import com.epam.lab.XMLConvert.ListObjectsConvert;
import com.epam.lab.XMLParser.XMLParserDOM;
import com.epam.lab.XMLParser.XMLParserSAX;
import com.epam.lab.XMLParser.XMLParserStAX;
import com.epam.lab.XMLValidation.XMLValidation;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Task 1.	Створити файл XML і відповідну йому схему XSD.
 * Paths: xml/old_card.xml, xml/old_card.xsd
 * Task 2.	При розробленні XSD використовувати прості та комплексі типи, переліки, шаблони та граничні значення.
 * Path: xml/old_card.xsd
 * Task 3.	Написати Java-клас, що відповідає поданому описанню.
 * class OldCard()
 * Task 4.	Створити Java-програму для опрацювання XML-документа та ініціалізації колекції об’єктів інформацією з XML-файлу.
 * Для опрацювання документа використовувати SAX, DOM та StAX парсери.
 * In package XMLParser:
 * class XMLParserSAX; class XMLReaderDOM; class XMLParserStAX;
 * Task 5.	Перевірити коректність XML-документа з використанням XSD.
 * In package XMLValidation:
 * class XMLValidation
 * Task 6.	Написати метод, що здійснює перетворення розробленого XML-документа за допомогою XSL у формат HTML
 * (відсортувавши об’єкти по одному з параметрів) та у формат XML зі зміненим кореневим елементом.
 * xsl file: xml/old_card.xsl
 * html file: xml/old_card.html
 * xsl file: xml/changeRootElement.xsl
 * new xml file: xml/new_old_card.xml
 * In package XMLConvert:
 * class ConvertToHTML(); class ConvertXML();
 * Sorting objects is done using a comparator and xsl:sort;
 * Task 7.	Для сортування об’єктів використовувати інтерфейс Comparator.
 * In package XMLConvert: class ThemeComparator()
 * Task 8.	Різниця між SAX та StAX.
 * Task 9.	XML за допомогою JAXB конвертувати в ліст об’єктів.
 * In package XMLConvert: class ListObjectsConvert()
 */

public class Main {
    public static void main(String[] args) throws TransformerException, JAXBException {
        System.out.println("Task 4");
        XMLParserDOM parserDOM = new XMLParserDOM();
        parserDOM.outputResults();
        XMLParserSAX parserSAX = new XMLParserSAX();
        parserSAX.outputResults();
        XMLParserStAX parserStAX = new XMLParserStAX();
        parserStAX.outputResults();
        System.out.println("Task 5");
        XMLValidation xmlValidation = new XMLValidation();
        System.out.println(String.format("\nold_card.xml validates against old_card.xsd? %s\n", xmlValidation.validateXMLSchema("xml/old_card.xsd", "xml/old_card.xml")));
        System.out.println("Task 6");
        ConvertToHTML convertToHTML = new ConvertToHTML();
        System.out.println(convertToHTML.toString());
        ConvertXML convertXML = new ConvertXML();
        System.out.println(convertXML.toString());
        System.out.println("Task 9");
        ListObjectsConvert listObjectsConvert = new ListObjectsConvert();
        List<OldCard> listOldCard;
        listOldCard = listObjectsConvert.outputResults();
        System.out.println("New task 7");
        listObjectsConvert.sortList(listOldCard);
    }
}
