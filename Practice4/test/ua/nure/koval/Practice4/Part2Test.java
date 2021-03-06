package ua.nure.koval.Practice4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Part2Test {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void fillFileWithRandomData() throws Exception {
        String fileName = "rawData.txt";
        File rawData = folder.newFile(fileName);

        Part2.fillFIle(fileName);
        Integer[] arr = Part2.read(fileName);

        assertTrue("fillFileWithRandomData", rawData.exists());
        assertTrue("fillFileWithRandomData", arr.length == Part2.N);
    }

    @Test
    public void sortArray() throws Exception {
        Integer[] seed = {44, 4, 1, 20};
        Integer[] expected = {1, 4, 20, 44};

        Integer[] actual = Part2.sortArray(seed);

        assertArrayEquals("arrays aren't equal", expected, actual);
    }

    @Test
    public void testMainSort() throws Exception {
        String expected = "input ==> 30 23 16 16 9 23 3 18 21 29 " + System.lineSeparator()
                + "output ==> 3 9 16 16 18 21 23 23 29 30 " + System.lineSeparator();

        PrintStream temp = System.out;
        OutputStream out = new ByteArrayOutputStream(expected.length() * 2);
        System.setOut(new PrintStream(out));

        Part2.main(new String[0]);

        System.setOut(temp);

        String actual = new String(((ByteArrayOutputStream) out).toByteArray());


        assertEquals("testMainSort", expected, actual);
    }


}
