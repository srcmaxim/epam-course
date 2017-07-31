package ua.nure.koval.Practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.regex.Matcher;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParserTest {

	Parser parser;

	@Before
	public void testConstructor() throws FileNotFoundException {
		parser = new Parser(new File("part4.txt"));
	}

	@Test(expected = FileNotFoundException.class)
	public void testInvalidConstructor() throws FileNotFoundException {
		new Parser(new File("INVALID_FILENAME"));
	}

	@Test
	public void iteratorTest() {
		Iterator<String> it = parser.iterator();
		Matcher m = parser.getPatternMatcher();
		while (it.hasNext()) {
			m.find();
			assertEquals(parser.getPatternMatcher().group().replace("  ", " "), it.next());
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void iteratorRemoveTest() {
		parser.iterator().remove();
	}
}
