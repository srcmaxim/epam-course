package ua.nure.koval.Practice6;

import ua.nure.koval.Practice6.part1.Part1;
import ua.nure.koval.Practice6.part2.Part2;
import ua.nure.koval.Practice6.part3.Part3;
import ua.nure.koval.Practice6.part4.Part4;
import ua.nure.koval.Practice6.part5.Part5;
import ua.nure.koval.Practice6.part6.Part6;
import ua.nure.koval.Practice6.part7.Part7;

public final class Demo {

	private Demo() {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("~~~~~~~~~~~~Part1");
		Part1.main(args);

		System.out.println("~~~~~~~~~~~~Part2");
		Part2.main(args);

		System.out.println("~~~~~~~~~~~~Part3");
		Part3.main(args);

		System.out.println("~~~~~~~~~~~~Part4");
		Part4.main(args);

		System.out.println("~~~~~~~~~~~~Part5");
		Part5.main(args);

		System.out.println("~~~~~~~~~~~~Part6");
		System.out.println("~~~~~~~~~~~~length");
		Part6.main(new String[]{"--input", "part6.txt", "--task", "length"});
		System.out.println("~~~~~~~~~~~~frequency");
		Part6.main(new String[]{"--input", "part6.txt", "--task", "frequency"});
		System.out.println("~~~~~~~~~~~~duplicates");
		Part6.main(new String[]{"--input", "part6.txt", "--task", "duplicates"});

		System.out.println("~~~~~~~~~~~~Part7");
		Part7.main(args);
	}

}