package com.epam.lab.XMLValidation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidation {
    public boolean validateXMLSchema(String xsdPath, String xmlPath) {
        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
