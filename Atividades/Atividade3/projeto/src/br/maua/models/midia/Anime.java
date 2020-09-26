package br.maua.models.midia;

/**
 * Classe filha de {@link Midia}, que implementa um objeto de anime. Contém as características exclusivas de um anime,
 * como número de episódios.
 */
public class Anime extends Midia {

	private final int episodios;

	public Anime(int id, String url, String titulo, String sinopse, int episodios, double nota) {
		super(id, url, titulo, sinopse, nota);
		this.episodios = episodios;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("----------|----------\n");
		str.append( String.format(
				"       ID : %s\n   Titulo : %s\n     Nota : %s\nEpisodios : %s\n      URL : %s\n  Sinopse : %s",
				id, titulo, nota, episodios, url, sinopse
		));
		str.append("\n----------|----------\n");

		return str.toString();
	}

	// Getters e Setters
	public int getEpisodios() {
		return episodios;
	}
}
