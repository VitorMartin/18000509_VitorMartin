package br.maua.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Classe responsável por implementar os métodos para interação com a API Jikan.
 */
public class Jikan {
	public static final String BUSCAR_ANIME = "anime";
	public static final String BUSCAR_MANGA = "manga";

	public static final String ID = "mal_id";
	public static final String URL = "url";
	public static final String TITULO = "title";
	public static final String SINOPSE = "synopsis";
	public static final String NOTA = "score";

	public static final String EPISODIOS = "episodes";

	public static final String CAPITULOS = "chapters";
	public static final String VOLUMES = "volumes";
	public static final String TIPO = "type";

	/**
	 * {@link JSONArray} com todas as mídias encontradas pela requisição feita ao servidor do My Anime List.
	 */
	private final JSONArray matches;

	/**
	 * Construtor da classe {@link Jikan}.
	 *
	 * @param categoria Qual mídia a ser pesquisada. Anime ou Mangá?
	 * @param titulo Título da mídia procurada.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Jikan(String categoria, String titulo) throws IOException, InterruptedException {
		JSONObject resposta = request(categoria, titulo);
		this.matches = resposta.getJSONArray("results");
	}

	/**
	 * Faz a requisição de informação ao servidor do My Anime List.
	 *
	 * @param categoria Qual mídia a ser pesquisada. Anime ou Mangá?
	 * @param titulo Título da mídia procurada.
	 * @return {@link JSONObject} com todas as informações referentes à requisição feita.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private JSONObject request(String categoria, String titulo) throws IOException, InterruptedException {
		final String urlBase = "https://api.jikan.moe/v3/search/%s?q=%s";
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

	/**
	 * @return {@link String} com todas as mídias armazenadas em {@link Jikan#matches}.
	 */
	public String mostrarTitulosEncontrados(){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < matches.length(); i++) {
			if (i >= 10) break; // Limitando busca aos 10 primeiros resultados. O resto da lista ainda existe, porem escondido do usuario.
			str.append(i).append("\t->\t").append(matches.getJSONObject(i).getString("title")).append("\n");
		}
		str.setLength(str.length() - 1);

		return str.toString();
	}

	// Getters e Setters
	public JSONArray getMatches() {
		return matches;
	}
}
