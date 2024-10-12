package tech.cybersword.common.inet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InternetChecker {

	private Logger logger = Logger.getLogger(InternetChecker.class.getName());

	private String checkUrl = "http://www.google.com";

	private static InternetChecker instance;

	private InternetChecker() {
		logger.log(Level.INFO, "check internet connection cheker");
		setConfigProxy();
	}

	public static InternetChecker getInstance() {
		if (null == instance) {
			instance = new InternetChecker();
		}
		return instance;
	}

	public boolean isInternetAvailable() {
		return isInternetAvailable(checkUrl);
	}

	public boolean isInternetAvailable(String checkUrl) {
		try {
			logger.info(String.format("check internet connection on ", checkUrl));
			if (null != checkUrl && !checkUrl.isEmpty()) {
				URL url = new URL(checkUrl);
				URLConnection conn = url.openConnection();
				conn.connect();
				conn.getInputStream().close();
				return true;
			}
		} catch (MalformedURLException e) {
			logger.log(Level.SEVERE, "error on internet check uri " + checkUrl, e);
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "error on internet check uri " + checkUrl, e);
		}
		return false;
	}

	private void setConfigProxy() {
		System.setProperty("java.net.useSystemProxies", "true");
	}
}