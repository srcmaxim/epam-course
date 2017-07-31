package ua.nure.koval.Practice4;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part5 {
	private Part5() {
	}

	private static final String BASE_NAME = "resources";
	private static final Pattern PATTERN = Pattern.compile("(\\w+)\\s(\\w+)",
			Pattern.MULTILINE
					| Pattern.UNICODE_CHARACTER_CLASS
					| Pattern.CASE_INSENSITIVE);


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in, Charset.defaultCharset().name());
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			if ("stop".equalsIgnoreCase(s)) {
				break;
			}
			Matcher matcher = PATTERN.matcher(s);
			if (matcher.find()) {
				String name = matcher.group(1);
				String lang = matcher.group(2);
				ResourceBundle resource = ResourceBundle.getBundle(BASE_NAME, new Locale(lang));
				System.out.println(resource.getString(name));
			}
		}
	}

}