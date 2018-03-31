package com.epam.lab.XMLConvert;

import com.epam.lab.Model.Constants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConvertXML {

    private void simpleTransform(final String sourcePath, final String xsltPath, final String resultDir) {
        final TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            final Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
            transformer.transform(new StreamSource(new File(sourcePath)), new StreamResult(resultDir));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        simpleTransform(Constants.pathToXML, Constants.newPathToXSL, Constants.newPathToXML);
        return "The results of operation are in xml/new_old_card.xml\n";
    }
}

