package ua.nure.koval.SummaryTask3.constants;

/**
 * This class holds application constants.
 *
 * @author M.Koval
 */

public final class Constants {

    /* files */
    public static final String VALID_XML_FILE = "input.xml";
    public static final String INVALID_XML_FILE = "input-invalid.xml";
    public static final String XSD_FILE = "input.xsd";

    /* validation features */
    public static final String FEATURE_TURN_VALIDATION_ON = "http://xml.org/sax/features/validation";
    public static final String FEATURE_TURN_SCHEMA_VALIDATION_ON = "http://apache.org/xml/features/validation/schema";

    /* output messages */
    private static final String BOUND = "====================================%n";

    public static final String VALID_OUTPUT = BOUND
            + "Here is the Medicines: %s%n"
            + BOUND;
    public static final String INVALID_OUTPUT = BOUND
            + "Validation is failed: %s%n"
            + "Here is the Medicines:  %s%n"
            + BOUND;

    private Constants() {
    }
}