package br.maua.models.midia;

/**
 * Classe que implementa um objeto de mídia. Contém as características de um mídia genérica, como título, sinopse, etc.
 */
public class Midia {

	protected final int id;
	protected final String url;
	protected final String titulo;
	protected final String sinopse;
	protected final double nota;

	public Midia(int id, String url, String titulo, String sinopse, double nota) {
		this.id = id;
		this.url = url;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.nota = nota;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTituloLower() {
		return titulo.toLowerCase();
	}

	public String getSinopse() {
		return sinopse;
	}

	public double getNota() {
		return nota;
	}
}
