package ua.nure.koval.SummaryTask3.controller;

import ua.nure.koval.SummaryTask3.constants.Constants;
import ua.nure.koval.SummaryTask3.entity.Medicine;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

/**
 * StAX parser for Medicine entities
 * uses polls style XML reading.
 * Don't do validation while reading.
 *
 * @author M.Koval
 * @see MedicineStreamReader logic of streaming parser
 */
public class STAXController extends MedicineStreamReader {

    /**
     * Name of XML
     */
    private String fileName;

    public STAXController(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) throws XMLStreamException {
        STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
        staxContr.parse();

        System.out.printf(Constants.VALID_OUTPUT, staxContr.getMedicines());
    }

    /**
     * Parses XML document with StAX (based on event reader). There is no validation during the
     * parsing.
     */
    public List<Medicine> parse() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        XMLEventReader reader = factory.createXMLEventReader(new StreamSource(fileName));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartDocument()) {
                medicines = new ArrayList<>();
            } else if (event.isStartElement()) {
                thisElement = event.asStartElement().getName().getLocalPart().trim();
                processCurrentElement();
            } else if (event.isCharacters()) {
                String data = event.asCharacters().getData().trim();
                processDataForCurrentElement(data);
            }
        }
        reader.close();
        return medicines;
    }

}
