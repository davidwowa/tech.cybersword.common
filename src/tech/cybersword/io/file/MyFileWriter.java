package tech.cybersword.io.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyFileWriter {

	public void writeInToFile(String filename, String content) {
		try (PrintWriter out = new PrintWriter(filename)) {
			out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}