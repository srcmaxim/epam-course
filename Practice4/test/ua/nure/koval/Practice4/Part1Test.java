package ua.nure.koval.Practice4;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Part1Test {

    @Test
    public void testMain() throws Exception {
        Part1.main(new String[0]);
    }

    @Test
    public void uppercaseWordsFromDefaultFile() throws Exception {
        List<String> exp = new ArrayList<String>() {{
            add("���� ���������� ��������� ���������� �� �����,");
            add("�� ���������� ������� ���������, � ");
            add("������� ��� (����������) ��������.");
        }};
        ByteArrayOutputStream out = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(out));

        Part1.input(exp, out);

        String actual = new String(out.toByteArray(), Charset.forName(Part1.ENCODING));

        StringBuilder expected= new StringBuilder();
        for (String s : exp) {
            expected.append(s).append(System.lineSeparator());
        }


        assertEquals("uppercaseWordsFromDefaultFile", expected.toString(), actual);
    }

}
