package ua.nure.koval.SummaryTask3.controller;

import ua.nure.koval.SummaryTask3.constants.XML;
import ua.nure.koval.SummaryTask3.entity.*;
import ua.nure.koval.SummaryTask3.entity.Package;
import ua.nure.koval.SummaryTask3.util.DateUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Abstract class for both implementation
 * of SAX and StAX parsers.
 *
 * @author M.Koval
 */
public abstract class MedicineStreamReader {

    /**
     * Stores Medecine entities
     */
    protected List<Medicine> medicines;

    /**
     * Current tag which are parsed by parser
     */
    protected String thisElement;

    /**
     * Method is used by parser while parsing from up to down.
     * <p>
     * Gets last version entity of last medicine
     * in <code>medicines<code/> collections.
     *
     * @return last version in collection
     */
    public Version getLastVersion() {
        return getLastMedicine().getVersions()
                .get(getLastMedicine().getVersions().size() - 1);
    }

    /**
     * Method is used by parser while parsing from up to down.
     * <p>
     * Gets last medicine entity
     * in <code>medicines<code/> collections.
     *
     * @return last medicine in collection
     */
    public Medicine getLastMedicine() {
        return getMedicines().get(medicines.size() - 1);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Saves new wrappers for group element like medicine, version, certificate
     * in medicine entity.
     * <p>
     * Compares internal string of <code>currentElement</code> with xml tags by ==.
     */
    public void processCurrentElement() {
        thisElement = thisElement.intern();
        if (thisElement == "") {
            return;
        } else if (thisElement == XML.MEDICINE.value()) {
            medicines.add(new Medicine());
        } else if (thisElement == XML.VERSION.value()) {
            getLastMedicine().getVersions().add(new Version());
        } else if (thisElement == XML.CERTIFICATE.value()) {
            getLastVersion().setCertificate(new Certificate());
        } else if (thisElement == XML.PACKAGE.value()) {
            getLastVersion().setaPackage(new Package());
        } else if (thisElement == XML.DOSAGE.value()) {
            getLastVersion().setDosage(new Dosage());
        }
    }

    /**
     * Ads text data for current group element.
     * <p>
     * Compares internal data of <code>currentElement</code> with xml tags by ==.
     *
     * @param internalText for current tag
     */
    public void processDataForCurrentElement(String internalText) {
        String data = internalText.intern();
        if (data == "") {
            return;
        } else if (thisElement == XML.NAME.value()) {
            getLastMedicine().setName(data);
        } else if (thisElement == XML.PHARM.value()) {
            getLastMedicine().setPharm(data);
        } else if (thisElement == XML.GROUP.value()) {
            getLastMedicine().setGroup(Group.fromValue(data));
        } else if (thisElement == XML.ANALOG_NAME.value()) {
            getLastMedicine().getAnalogs().add(data);
        } else if (thisElement == XML.NUMBER.value()) {
            getLastVersion().getCertificate().setNumber(
                    Integer.parseInt(data)
            );
        } else if (thisElement == XML.START_DATE.value()) {
            getLastVersion().getCertificate().setStartDate(
                    DateUtil.fromString(data)
            );
        } else if (thisElement == XML.EXPIRATION_DATE.value()) {
            getLastVersion().getCertificate().setExpirationDate(
                    DateUtil.fromString(data)
            );
        } else if (thisElement == XML.REGISTERED_BY.value()) {
            getLastVersion().getCertificate().setRegisteredBy(
                    data
            );
        } else if (thisElement == XML.PACKAGE_TYPE.value()) {
            getLastVersion().getaPackage().setPackageType(
                    data
            );
        } else if (thisElement == XML.AMOUNT.value()) {
            getLastVersion().getaPackage().setAmount(
                    Integer.parseInt(data)
            );
        } else if (thisElement == XML.PRICE.value()) {
            getLastVersion().getaPackage().setPrice(
                    new BigDecimal(data)
            );
        } else if (thisElement == XML.VALUE.value()) {
            getLastVersion().getDosage().setValue(
                    Integer.parseInt(data)
            );
        } else if (thisElement == XML.PERIOD.value()) {
            getLastVersion().getDosage().setPeriod(
                    data
            );
        }
    }

}
