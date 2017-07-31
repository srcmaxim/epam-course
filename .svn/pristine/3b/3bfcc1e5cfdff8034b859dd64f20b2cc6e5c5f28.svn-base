package ua.nure.koval.Practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

final class Util {

    private static final String ENCODING = "UTF-8";
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

    private Util() {

    }

    static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("./Part1.txt"));
        System.out.println(readFile("./Part2.txt"));
        System.out.println(readFile("./Part3.txt"));
    }

}
