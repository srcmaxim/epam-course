package ua.nure.koval.SummaryTask3.entity;

public class Version {

    protected Certificate certificate;
    protected Package aPackage;
    protected Dosage dosage;

    public Version(Certificate certificate, Package aPackage, Dosage dosage) {
        this.certificate = certificate;
        this.aPackage = aPackage;
        this.dosage = dosage;
    }

    public Version() {
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "\n\t\tVersion{" +
                "\n\t\tcertificate=" + certificate +
                ", \n\t\tpackage=" + aPackage +
                ", \n\t\tdosage=" + dosage +
                '}';
    }
}
