package com.epam.lab.XMLConvert;

import com.epam.lab.Model.Constants;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ConvertToHTML {
    @Override
    public String toString() {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource(Constants.pathToXSLSort);
        Source xmlDoc = new StreamSource(Constants.pathToXML);
        String outputFileName = Constants.pathToHTML;
        try (OutputStream htmlFile = new FileOutputStream(outputFileName)) {
            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "The results of operation are in xml/old_card.html";
    }
}