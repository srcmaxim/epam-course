package ua.nure.koval.Practice6.part1;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;
import java.util.Iterator;
import java.util.Scanner;

public final class Part1 {

	private Part1() {
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		wordCounter(new StringBufferInputStream("Du\n" +
                "hast\n" +
                "mich\n" +
                "Du\n" +
                "hast\n" +
                "mich\n" +
                "Du\n" +
                "hast\n" +
                "mich\n" +
                "gefragt\n" +
                "stop"), System.out);
	}

	public static void wordCounter(InputStream in, PrintStream out) {
		Scanner scanner = new Scanner(in);
		WordContainer wordContainer = new WordContainer(new Word.CompareByWord());
		while (scanner.hasNext()) {
			String word = scanner.nextLine();
			if (word.equals("stop")) {
				break;
			}
			wordContainer.add(new Word(word));
		}

		Iterator iterator = wordContainer.frequencyIterator();
		while (iterator.hasNext()) {
			Word w = (Word) iterator.next();
			out.printf("%s:%s%n", w.getValue(), w.getFrequency());
		}
	}

}
