package ua.nure.koval.Practice1;

import static java.lang.System.out;

public final class Demo {

    private Demo() {
    }
    
    public static void main(String[] args) {
        out.print("Part1: ");
        Part1.main(new String[0]);
        out.println();

        out.print("Part2: 3 + 4 = ");
        Part2.main(new String[]{"3", "4"});
        out.println();

        out.print("Part3: NOD(24,36) = ");
        Part3.main(new String[]{"24", "36"});
        out.println();

        out.print("Part4: 123 = ");
        Part4.main(new String[]{"123"});
        out.println();

        out.println("Part5:");
        Part5.printer("A");
        Part5.printer("B");
        Part5.printer("Z");
        Part5.printer("AA");
        Part5.printer("AZ");
        Part5.printer("BA");
        Part5.printer("ZZ");
        Part5.printer("AAA");
    }

}
