package tech.cybersword.common.property.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyPropertyReader {

	private Logger logger = Logger.getLogger(MyPropertyReader.class.getName());

	public Properties loadPropertiesFrom(String path) {
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("read properties from %s", path));
		}
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream(path)) {
			properties.load(fis);
			return properties;
		} catch (IOException e) {
			if (logger.isLoggable(Level.SEVERE)) {
				logger.severe(String.format("error on read property file from %s", path));
			}
			e.printStackTrace();
		}
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		try (InputStream stream = loader.getResourceAsStream(path)) {
//			Properties properties = new Properties();
//			properties.load(stream);
//			return properties;
//		} catch (IOException e) {
//			if (logger.isLoggable(Level.SEVERE)) {
//				logger.severe(String.format("error on read property file from %s", path));
//			}
//			e.printStackTrace();
//		}
		return new Properties();
	}
}