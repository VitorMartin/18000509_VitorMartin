package br.maua.models.midia;

public class Anime extends Midia {
	public static final String EPISODIOS = "episodes";

	private final int episodios;

	public Anime(int id, String url, String titulo, String sinopse, int episodios, double nota) {
		super(id, url, titulo, sinopse, nota);
		this.episodios = episodios;
	}

	@Override
	public String toString() {
		String str = String.format(
				"       ID : %s\n   Titulo : %s\n     Nota : %s\nEpisodios : %s\n      URL : %s\n  Sinopse : %s",
				id, titulo, nota, episodios, url, sinopse
		);

		return str;
	}
}
