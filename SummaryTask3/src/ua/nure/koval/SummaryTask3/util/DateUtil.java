package ua.nure.koval.SummaryTask3.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter for <code>Date</code> from/to String.
 * in ISO 8601 date format.
 *
 * @author M.Koval
 * @see <a href="https://ru.wikipedia.org/wiki/ISO_860">ISO 8601</a>
 */
public final class DateUtil {

    /*
     * SimpleDateFormat not thread save
     */
    private static final SimpleDateFormat ISO_8601_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private DateUtil() {
    }

    /**
     * Parses String to Date.
     *
     * @param date Date in ISO 8601 format.
     * @return parsed Date.
     * @throws RuntimeException if date not in ISO 8601 format.
     */
    public static synchronized Date fromString(String date) {
        try {
            return ISO_8601_DATE_FORMAT.parse(date);
        } catch (Exception e) {
            System.out.println("Exception with parsing Date");
            throw new RuntimeException(e);
        }
    }

    /**
     * Formats Date to String.
     *
     * @param startDate formatted Date.
     * @return String representation of date in ISO 8601 format.
     */
    public static synchronized String toString(Date startDate) {
        return ISO_8601_DATE_FORMAT.format(startDate);
    }
}
