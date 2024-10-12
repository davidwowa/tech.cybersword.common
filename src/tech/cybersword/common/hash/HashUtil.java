package tech.cybersword.common.hash;

import java.util.Base64;

public class HashUtil {

	public static String getBase64String(String string) {
		if (null != string && !string.isEmpty()) {
			return Base64.getEncoder().encodeToString(string.getBytes());
		}
		return null;
	}

	public static String getStringFromBase64(String string) {
		if (null != string && !string.isEmpty()) {
			return new String(Base64.getDecoder().decode(string));
		}
		return null;
	}
}
