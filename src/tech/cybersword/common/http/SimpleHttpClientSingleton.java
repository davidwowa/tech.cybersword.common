package tech.cybersword.common.http;

public class SimpleHttpClientSingleton {

	private static SimpleHttpClientSingleton instance;

	private static SimpleHttpClient httpClient;

	private SimpleHttpClientSingleton() {
		httpClient = new SimpleHttpClient();
	}

	public static SimpleHttpClient getSimpleHttpClient() {
		if (null == instance) {
			instance = new SimpleHttpClientSingleton();
		}
		return httpClient;
	}
}