package br.maua.models.midia;

public class Anime extends Midia {

	private final int episodios;

	public Anime(int id, String url, String titulo, String sinopse, int episodios, double nota) {
		super(id, url, titulo, sinopse, nota);
		this.episodios = episodios;
	}

	@Override
	public String toString() {
		return String.format(
				"       ID : %s\n   Titulo : %s\n     Nota : %s\nEpisodios : %s\n      URL : %s\n  Sinopse : %s",
				id, titulo, nota, episodios, url, sinopse
		);
	}

	// Getters e Setters
	public int getEpisodios() {
		return episodios;
	}
}
