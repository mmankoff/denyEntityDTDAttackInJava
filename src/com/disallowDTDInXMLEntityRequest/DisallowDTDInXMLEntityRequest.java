package com.disallowDTDInXMLEntityRequest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.concurrent.atomic.AtomicReference;

class SafeBuilder {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    String FEATURE;

    {

        FEATURE = "https://xerces.apache.org/xerces2-j/features.html#disallow-doctype-decl";
        try {
            dbf.setFeature(FEATURE, true);
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }


        FEATURE = "https://xml.org/sax/features/external-general-entities";
        try {
            dbf.setFeature(FEATURE, false);
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }


        FEATURE = "https://xml.org/sax/features/external-parameter-entities";
        try {
            dbf.setFeature(FEATURE, false);
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }


        FEATURE = "https://apache.org/xml/features/nonvalidating/load-external-dtd";
        try {
            dbf.setFeature(FEATURE, true);
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }


        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);
    }

    protected final AtomicReference<DocumentBuilder> safeBuilder = new AtomicReference<>();

}



