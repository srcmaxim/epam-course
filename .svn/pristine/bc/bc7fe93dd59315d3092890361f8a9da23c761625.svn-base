package ua.nure.koval.Practice3;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part2 {

    public static String convert(String input) {
        Matcher matcher = Pattern.compile("(?<=^|\\s|\\-|\\'|)[a-zA-Z\\u0410-\\u044F]*")
                .matcher(input);
        Set<String> splited = new LinkedHashSet<>();

        MinMax minMax = new MinMax(matcher).addValuesToSet(splited);
        int min = minMax.getMin();
        int max = minMax.getMax();

        return getResultAsString(splited, min, max);
    }

    private static String getResultAsString(Set<String> splited, int min, int max) {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Min: ");
        for (String s : splited) {
            if (s.length() == min) {
                sb = sb.append(s).append(", ");
            }
        }
        sb = sb.replace(sb.length() - 2, sb.length(), System.lineSeparator())
                .append("Max: ");
        for (String s : splited) {
            if (s.length() == max) {
                sb = sb.append(s).append(", ");
            }
        }
        return sb.toString().replaceFirst(System.lineSeparator() + "\\[a-z]|\\,\\s*$", "");
    }

    private static class MinMax {
        private Matcher matcher;
        private int min;
        private int max;

        MinMax(Matcher matcher) {
            this.matcher = matcher;
        }

        int getMin() {
            return min;
        }

        int getMax() {
            return max;
        }

        MinMax addValuesToSet(Set<String> splited) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            while (matcher.find()) {
                String s = matcher.group();
                min = (min > s.length() && s.length() != 0) ? s.length() : min;
                max = (max < s.length()) ? s.length() : max;
                splited.add(matcher.group());
            }
            return this;
        }
    }
}
