package ua.nure.koval.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part3 {

    public static String convert(String input) {
        StringBuffer result = new StringBuffer();
        Matcher matcher = Pattern.compile("(?<=^|\\s)[a-z\\u0430-\\u044F](?=[\\w\\u0410-\\u044F])", Pattern.MULTILINE).matcher(input);
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group().toUpperCase());
        }
        matcher.appendTail(result);
        return result.toString();
    }

}
