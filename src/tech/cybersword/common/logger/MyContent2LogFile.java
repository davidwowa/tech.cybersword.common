package tech.cybersword.common.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.logging.Logger;

public class MyContent2LogFile {

	private Logger logger = Logger.getLogger(MyContent2LogFile.class.getName());

	public void log2File(String pathWithFileName, String content, boolean showOnConsole, boolean append,
			boolean dateAppend) {
		if (dateAppend) {
			content = new Date() + " " + content;
		}
		if (showOnConsole) {
			logger.info(content);
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathWithFileName, append))) {
			writer.append(content);
			writer.append("\n");
		} catch (Exception e) {
			logger.severe("Error on writing in file: " + pathWithFileName);
			e.printStackTrace();
		}
	}

	public void log2CSVFile(String pathWithFileName, String content) {
		log2File(pathWithFileName, content, true, true, false);
	}

	public void log2File(String pathWithFileName, String content, boolean append) {
		log2File(pathWithFileName, content, true, append, true);
	}

	public void log2File(String pathWithFileName, String content) {
		log2File(pathWithFileName, content, true, true, true);
	}

	public void log2FileOtherFormat(String pathWithFileName, String content) {
		log2File(pathWithFileName, content, true, true, false);
	}
}