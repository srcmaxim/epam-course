package ua.nure.koval.Practice3;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part1 {

    private static final Pattern LOGIN_NAME_EMAIL = Pattern
            .compile("(([a-z\\u0410-\\u044F]+);([\\w\\u0410-\\u044F]+\\s[\\w\\u0410-\\u044F]+);(\\w+@(\\w+.\\w+)))", Pattern.MULTILINE);

    public static String convert1(String input) {
        return input.replaceAll(LOGIN_NAME_EMAIL.pattern(), "$2 ==> $4").replaceFirst(".*"
                + System.lineSeparator(), "");
    }

    public static String convert2(String input) {
        return input.replaceAll(LOGIN_NAME_EMAIL.pattern(), "$3 (email: $4)").replaceFirst(".*"
                + System.lineSeparator(), "");
    }

    public static String convert3(String input) {
        Matcher matcher = LOGIN_NAME_EMAIL.matcher(input);
        Map<String, List<String>> listToMap = new LinkedHashMap<>();

        while (matcher.find()) {
            String email = matcher.group(5);
            List<String> list;
            if ((list = listToMap.get(email)) == null) {
                list = new ArrayList<>();
                listToMap.put(email, list);
            }
            list.add(matcher.group(2));
        }

        StringBuilder emails = new StringBuilder(input.length() / 2);


        for (Map.Entry<String, List<String>> key : listToMap.entrySet()) {
            emails = emails.append(key.getKey()).append(" ==> ");
            for (String name : key.getValue()) {
                emails = emails.append(name).append(", ");
            }
            emails = emails.replace(emails.length() - 2, emails.length(), System.lineSeparator());
        }

        return emails.replace(emails.length() - 1,
                emails.length(), "").toString();
    }

    public static String convert4(String input) {
        Matcher matcher = LOGIN_NAME_EMAIL.matcher(input);
        StringBuffer sb = new StringBuffer();
        Random r = new SecureRandom();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "$1;" + 1000 + r.nextInt(9000));
        }
        return sb.toString();
    }
}
