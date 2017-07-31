package ua.nure.koval.Practice4;

import java.io.File;
import java.io.FileNotFoundException;


public class Part4 {

	Part4(String filename) {
		setFileName(filename);
	}

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void output() throws FileNotFoundException {
		Parser parser = new Parser(new File(getFileName()));
		for (String str : parser) {
			System.out.println(str);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		new Part4("part4.txt").output();
	}
}