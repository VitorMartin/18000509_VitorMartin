package br.maua.models.midia;

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
}
