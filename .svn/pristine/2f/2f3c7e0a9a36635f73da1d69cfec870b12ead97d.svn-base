package ua.nure.koval.Practice4;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class Part4Test {

	Part4 part4;

	class Mock extends Parser {

		public Mock(File file) throws FileNotFoundException {
			super(file);
		}
	}

	public Parser getMock() throws FileNotFoundException {
		Parser parser = new Mock(new File("part4.txt"));
		return parser;
	}

	@Before
	public void constructorTest() {
		part4 = new Part4("part4.txt") {
			@Override
			public void output() throws FileNotFoundException {
				for (String str : getMock()) {
					System.out.println(str);
				}
			}
		};
	}

	@Test
	public void testOutput() throws FileNotFoundException {
		part4.output();
	}

	@Test
	public void testMain() throws FileNotFoundException {
		Part4.main(new String[] {});
	}

}