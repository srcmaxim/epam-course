package ua.nure.koval.Practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part1 {

    private Part1() {
    }

    public static final String FILE_NAME = "part1.txt";

    public static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(new File(FILE_NAME).toPath(), Charset.forName(ENCODING));

        ByteArrayOutputStream out = new ByteArrayOutputStream(100);
        PrintStream o = System.out;
        System.setOut(new PrintStream(out,true, Charset.defaultCharset().name()));
        input(strings, System.out);

        String actual = new String(out.toByteArray(), Charset.forName(Part1.ENCODING));

        System.setOut(o);
        System.out.print(actual);
    }

    public static void input(List<String> strings , OutputStream out) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s).append(System.lineSeparator());
        }

        Matcher matcher = Pattern.compile("[\\w]{4,}",
                Pattern.MULTILINE
                        | Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE).matcher(sb);

        sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group().toUpperCase());
        }
        matcher.appendTail(sb);

        out.write(sb.toString().getBytes(ENCODING));
    }

}