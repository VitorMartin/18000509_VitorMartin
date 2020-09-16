package br.maua.api;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Jikan {
	private static final String urlBase = "https://api.jikan.moe/v3/search/%s?q=%s";
	public  static final String ANIME = "anime";
	public  static final String MANGA = "manga";

	public static JSONObject request(String categoria, String titulo) throws Exception {
		URI uri = URI.create(
				String.format(
						urlBase,
						categoria,
						titulo.replace(" ", "%20")
				)
		);

		HttpClient client = HttpClient
				.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10))
				.build();

		HttpRequest request = HttpRequest
				.newBuilder()
				.GET()
				.uri(uri)
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("   URI : " + uri);
		System.out.println("Status : " + response.statusCode());
		System.out.println("  Body : " + response.body());

		return new JSONObject(response.body());
	}
}
