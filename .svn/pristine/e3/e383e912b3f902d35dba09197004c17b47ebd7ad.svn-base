package ua.nure.koval.SummaryTask3.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.nure.koval.SummaryTask3.entity.Certificate;
import ua.nure.koval.SummaryTask3.entity.Dosage;
import ua.nure.koval.SummaryTask3.entity.Medicine;
import ua.nure.koval.SummaryTask3.entity.Version;

import java.util.List;

/**
 * Interface for reading List<Medicine> entity from XML DOM.
 *
 * @author M.Koval
 */
public interface InputMedicineDOMController {

    /**
     * Converts DOM representation of the entity to object representation.
     *
     * @param medicinesDom DOM representation of the entity.
     * @return List<Medicine> object representation of the entity.
     */
    List<Medicine> getMedicinesFromDom(Document medicinesDom);

    /* other methods are used as internal */

    Medicine getMedicineFromDom(Element medicineDom);

    List<String> getAnalogsFromDom(Element medicineDom);

    List<Version> getVersionsFromDom(Element medicineDom);

    Certificate getCertificateFromDom(Element versionDom);

    ua.nure.koval.SummaryTask3.entity.Package getaPackageFromDom(Element versionDom);

    Dosage getDosageFromDom(Element versionDom);
}
