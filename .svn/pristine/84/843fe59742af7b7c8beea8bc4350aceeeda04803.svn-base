package ua.nure.koval.SummaryTask3.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.nure.koval.SummaryTask3.entity.Medicine;
import ua.nure.koval.SummaryTask3.entity.Version;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * Interface for writing List<Medicine> entity to XML DOM.
 *
 * @author M.Koval
 */
public interface OutputMedicineDOMController {

    /**
     * Converts object representation of the entity to DOM representation.
     *
     * @param medicines object representation of the entity.
     * @return Document DOM representation of the entity.
     * @throws ParserConfigurationException
     */
    Document addMedicinesToDom(List<Medicine> medicines) throws ParserConfigurationException;

    /* other methods are used as internal */

    void addMedicineToDom(List<Medicine> medicines, Element medecinesDom);

    void addAnalogsToDom(Medicine medicine, Element medecineDom);

    void addVersionsToDom(Medicine medicine, Element medecineDom);

    void addCertificateToDom(Version version, Element versionDom);

    void addPackageToDom(Version version, Element versionDom);

    void addDosageToDom(Version version, Element versionDom);
}
