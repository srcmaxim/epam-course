package ua.nure.koval.SummaryTask3;

import org.xml.sax.SAXException;
import ua.nure.koval.SummaryTask3.controller.DOMController;
import ua.nure.koval.SummaryTask3.controller.SAXController;
import ua.nure.koval.SummaryTask3.controller.STAXController;
import ua.nure.koval.SummaryTask3.entity.Medicine;
import ua.nure.koval.SummaryTask3.util.Sorter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

/**
 * Entry point for st3 example (simple version).
 *
 * @author M.Koval
 */
public final class Main {

    private Main() {
    }

    public static void usage() {
        System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
        System.out.println("java Main xmlFileName");
    }

    public static void main(String[] args)
            throws IOException, SAXException, ParserConfigurationException, TransformerException, XMLStreamException {
        if (args.length != 1) {
            usage();
            return;
        }

        String fileName = args[0];
        inputFileLog("Input ==> " + fileName);

        ////////////////////////////////////////////////////////
        // DOM
        ////////////////////////////////////////////////////////

        // get
        DOMController domController = new DOMController(fileName);
        domController.parse(true);
        List<Medicine> medecines = domController.getMedicines();

        // sort (case 1)
        Sorter.sortByName(medecines);

        // save
        String outputXmlFile = "output.dom.xml";
        DOMController.saveToXML(medecines, outputXmlFile);
        outputFileLog(outputXmlFile);

        ////////////////////////////////////////////////////////
        // SAX
        ////////////////////////////////////////////////////////

        // get
        SAXController saxController = new SAXController(fileName);
        saxController.parse(true);
        medecines = saxController.getMedicines();

        // sort  (case 2)
        Sorter.sortByAnalogNumber(medecines);

        // save
        outputXmlFile = "output.sax.xml";

        // other way:
        DOMController.saveToXML(medecines, outputXmlFile);
        outputFileLog(outputXmlFile);

        ////////////////////////////////////////////////////////
        // StAX
        ////////////////////////////////////////////////////////

        // get
        STAXController staxController = new STAXController(fileName);
        staxController.parse();
        medecines = staxController.getMedicines();

        // sort  (case 3)
        Sorter.sortByVersionsMinExparationDate(medecines);

        // save
        outputXmlFile = "output.stax.xml";
        DOMController.saveToXML(medecines, outputXmlFile);
        outputFileLog(outputXmlFile);
    }

    private static void outputFileLog(String outputXmlFile) {
        System.out.println("Output ==> " + outputXmlFile);
    }

    private static void inputFileLog(String x) {
        System.out.println(x);
    }

}