package ua.nure.koval.SummaryTask3.controller;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.koval.SummaryTask3.constants.Constants;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SAX parser for Medicine entities.
 * Can use validation while reading.
 *
 * @author M.Koval
 * @see MedicineStreamReader logic of streaming parser
 */
public class SAXController extends MedicineStreamReader {

    /**
     * Name of XML
     */
    private String fileName;

    public SAXController(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Parses XML document.
     *
     * @param validate If true validate XML document against its XML schema. With
     *                 this parameter it is possible make parser validating.
     */
    public void parse(boolean validate)
            throws ParserConfigurationException, SAXException, IOException {

        // obtain sax parser factory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // XML document contains namespaces
        factory.setNamespaceAware(true);

        // set validation over xml and xsd
        if (validate) {
            factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser parser = factory.newSAXParser();
        parser.parse(fileName, new SAXHandler());
    }


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        // try to parse valid XML file (success)
        SAXController saxContr = new SAXController(Constants.VALID_XML_FILE);

        // do parse with validation on (success)
        saxContr.parse(true);

        // we have Test object at this point:
        System.out.printf(Constants.VALID_OUTPUT, saxContr.getMedicines());

        // now try to parse NOT valid XML (failed)
        saxContr = new SAXController(Constants.INVALID_XML_FILE);
        try {
            // do parse with validation on (failed)
            saxContr.parse(true);
        } catch (Exception e) {
            System.err.printf(Constants.INVALID_OUTPUT, e.getMessage(), saxContr.getMedicines());
        }

        // and now try to parse NOT valid XML with validation off (success)
        saxContr.parse(false);

        // we have Test object at this point:
        System.out.printf(Constants.VALID_OUTPUT, saxContr.getMedicines());
    }

    /**
     * Implementation of <code>DefaultHandler</code> for event style
     * XML reading.
     * Use logic of <code>MedicineStreamReader</code>
     */
    private class SAXHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            medicines = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            thisElement = qName.trim();
            processCurrentElement();
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            processDataForCurrentElement(data);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            thisElement = "";
        }

        @Override
        public void error(org.xml.sax.SAXParseException e) throws SAXParseException {
            // if XML document not valid just throw exception
            throw e;
        }
    }

}
