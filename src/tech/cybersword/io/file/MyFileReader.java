package tech.cybersword.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

	public String readFileAsString(String file) {
		try (Scanner s = new Scanner(new File(file)).useDelimiter("\\Z")) {
			return s.next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}