package ua.nure.koval.Practice3;

public final class Part5 {

    private static final String[] ROMAN =
            new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARAB =
            new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String decimal2Roman(int digit) {
        int x = digit;

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < ROMAN.length; i++) {
            while (x >= ARAB[i]) {
                s.append(ROMAN[i]);
                x -= ARAB[i];
            }
        }
        return s.toString();
    }

    public static int roman2Decimal(String digit) {
        StringBuilder roman = new StringBuilder(digit);

        int arab = 0;
        int number = 0;
        /* для каждой римской цифры */
        while (roman.length() != 0) {
            /* для повторяющейся римской цифры */
            if (roman.indexOf(ROMAN[number]) == 0) {
                arab += ARAB[number];
                roman.delete(0, ROMAN[number].length());
                continue;
            }
            number++;
        }
        return arab;
    }

}
