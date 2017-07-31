package ua.nure.koval.Practice4;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.MissingResourceException;

public class Part5Test {

	@Test
	public void test1() throws UnsupportedEncodingException {
			System.setIn(new ByteArrayInputStream("".getBytes("CP1251")));
			Part5.main(new String[0]);
	}

	@Test(expected = MissingResourceException.class)
	public void test2() throws UnsupportedEncodingException {
			System.setIn(new ByteArrayInputStream(
					("incorrectKey ru").getBytes("CP1251")));
			Part5.main(new String[0]);
	}

	@Test
	public void test3() throws UnsupportedEncodingException {
			System.setIn(new ByteArrayInputStream(
					("table ru\ntable en\napple ru\nstop\n................")
							.getBytes("CP1251")));
			Part5.main(new String[0]);
	}

}
