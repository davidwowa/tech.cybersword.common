package tech.cybersword.common.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import tech.cybersword.common.inet.InternetChecker;

public class SimpleHttpClient {

	private Logger logger = Logger.getLogger(SimpleHttpClient.class.getName());

	public String sendRequest(String url, int internetAvailableTimeout)
			throws URISyntaxException, InterruptedException, IOException {
		String quotedURL = URLDecoder.decode(url, StandardCharsets.UTF_8.name());

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(quotedURL)).GET().build();

		checkInternetAvailability(internetAvailableTimeout);

		HttpResponse<String> response2 = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());

		logger.info(String.format("HTTP_code %s %s", response2.statusCode(), url));

		return response2.body();
	}

	private void checkInternetAvailability(int value) throws InterruptedException {
		while (!InternetChecker.getInstance().isInternetAvailable()) {
			TimeUnit.SECONDS.sleep(value);
		}
	}
}