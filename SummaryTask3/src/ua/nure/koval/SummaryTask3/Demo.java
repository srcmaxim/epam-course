package ua.nure.koval.SummaryTask3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Demo class to run project WO command line.
 *
 * @author M.Koval
 */
public final class Demo {

    private Demo() {
    }

    public static void main(String[] args) throws SAXException, TransformerException,
            ParserConfigurationException, XMLStreamException, IOException {
        Main.main(new String[]{"input.xml"});
    }

}