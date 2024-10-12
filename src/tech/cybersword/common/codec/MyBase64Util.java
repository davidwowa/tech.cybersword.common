package tech.cybersword.common.codec;

import java.util.Base64;

public class MyBase64Util {

	public static String decode(String data) {
		return new String(Base64.getDecoder().decode(data.getBytes()));
	}

	public static void main(String[] args) {
		System.out.println(decode("???"));
	}
}