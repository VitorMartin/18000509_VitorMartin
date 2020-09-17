package br.maua.api;

import org.json.JSONArray;
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

	private final JSONArray matches;

	public Jikan(String categoria, String titulo) throws Exception {
		JSONObject resposta = request(categoria, titulo);
		this.matches = resposta.getJSONArray("results");
	}

	private JSONObject request(String categoria, String titulo) throws Exception {
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

		return new JSONObject(response.body());
	}

	public String mostrarTitulosEncontrados(){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < matches.length(); i++) {
			if (i >= 10) break; // Limitando busca aos 10 primeiros resultados
			str.append(i + "\t->\t" + matches.getJSONObject(i).getString("title") + "\n");
		}
		str.setLength(str.length() - 1);

		return str.toString();
	}

	// Getters e Setters
	public JSONArray getMatches() {
		return matches;
	}
}
