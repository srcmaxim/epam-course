package ua.nure.koval.Practice1;

public final class Part5 {

    private static final int BASE_26 = 26;

    private Part5() {
    }

    public static void main(String[] args) {
        printer("A");
        printer("B");
        printer("Z");
        printer("AA");
        printer("AZ");
        printer("BA");
        printer("ZZ");
        printer("AAA");
    }

    public static void printer(String number) {
        int digits = chars2digits(number);
        System.out.println(number + " ==> " + digits + " ==> " + digits2chars(digits));
    }

    public static String rightColumn(String number) {
        int digits = chars2digits(number);
        return digits2chars(digits + 1);
    }

    public static int chars2digits(String number) {
        int result = charToInt(number.charAt(number.length() - 1));
        int pow = 1;
        for (int i = number.length() - 2; i >= 0; i--) {
            result += Math.pow(BASE_26, pow) * charToInt(number.charAt(i));
            pow++;
        }
        return result;
    }

    public static int charToInt(char character) {
        return character - 'A' + 1;
    }

    public static String digits2chars(int number) {
        StringBuilder result = new StringBuilder();
        int digits = number;
        int mod;
        while (digits != 0) {
            digits--;
            mod = digits % BASE_26;
            result.insert(0, intToChar(mod));
            digits /= BASE_26;
        }
        return result.toString();
    }

    public static char intToChar(int digit) {
        return (char) ('A' + digit);
    }

}
