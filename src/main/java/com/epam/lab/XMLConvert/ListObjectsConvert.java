package com.epam.lab.XMLConvert;

import com.epam.lab.Model.Constants;
import com.epam.lab.Model.OldCard;
import com.epam.lab.Model.OldCards;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListObjectsConvert {
    private OldCards oldCards;

    public void sortList(List<OldCard> list) {
        Collections.sort(list, new ThemeComparator());
        for (OldCard st : list) {
            System.out.println(st.toString());
        }
    }

    public List<OldCard> outputResults() {
        List<OldCard> listOldCard = new ArrayList<>();
        try {
            File file = new File(Constants.pathToXML);
            JAXBContext jaxbContext = JAXBContext.newInstance(OldCards.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            oldCards = (OldCards) unmarshaller.unmarshal(file);
            List<OldCard> list = oldCards.getOldCard();
            listOldCard = list;
            for (OldCard oldCard : list) {
                System.out.println(oldCard.toString());
            }
            System.out.println();
            Collections.sort(list, new ThemeComparator());
            sortElements();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return listOldCard;
    }

    private void transformHTML(String outputFileName, Transformer transformer, JAXBSource source) {
        try (OutputStream htmlFile = new FileOutputStream(outputFileName)) {
            transformer.transform(source, new StreamResult(htmlFile));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void sortElements() {
        String outputFileName = Constants.pathToSortedHTML;
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(Constants.pathToXSL);
        Transformer transformer = null;
        try {
            transformer = tf.newTransformer(xslt);
            JAXBContext jc = JAXBContext.newInstance(OldCards.class);
            JAXBSource source = new JAXBSource(jc, oldCards);
            transformHTML(outputFileName, transformer, source);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}