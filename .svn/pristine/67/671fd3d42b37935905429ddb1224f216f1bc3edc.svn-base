package ua.nure.koval.Practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Demo {

    private static final InputStream STD_IN = System.in;

    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws IOException {
        System.out.println("=========================== PART1");
        Part1.main(args);

        System.out.println("=========================== PART2");
        Part2.main(args);

        System.out.println("=========================== PART3");
        // set the mock input
        System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble".getBytes(ENCODING)));
        Part3.main(args);
        // restore the standard input
        System.setIn(STD_IN);

        System.out.println("=========================== PART4");
        Part4.main(args);


        System.out.println("=========================== PART5");
        // set the mock input
        System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes(ENCODING)));
        Part5.main(args);
        // restore the standard input

    }

}