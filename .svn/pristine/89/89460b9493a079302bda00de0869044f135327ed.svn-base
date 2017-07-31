package ua.nure.koval.Practice3;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public final class Part4 {


    private static final Logger LOGGER = Logger.getLogger(Part4.class.getName());

    public static void main(String[] args) {
        try {
            System.out.println(hash("password", "SHA-256"));
            System.out.println(hash("passwort", "SHA-256"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            LOGGER.warning(ex.getMessage());
        }
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes("UTF-8"));

        byte[] hash = digest.digest();
        char[] chars = new char[hash.length * 2];

        for (int i = 0; i < hash.length; i++) {
            toChars(hash[i], chars, i);
        }

        return new String(chars);
    }

    private static void toChars(byte b, char[] chars, int i) {
        int upper = b & 0b1111_0000;
        upper = Math.abs(upper / 16);
        chars[i * 2] = toHex(upper);

        int lower = b & 0b0000_1111;
        chars[i * 2 + 1] = toHex(lower);
    }

    private static char toHex(int a) {
        return (a < 10) ? (char) (a + '0') : (char) (a + 'A' - 10);
    }
}
