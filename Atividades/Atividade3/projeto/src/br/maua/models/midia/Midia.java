package br.maua.models.midia;

public class Midia {
	public static final String ID = "mal_id";
	public static final String URL = "url";
	public static final String TITULO = "title";
	public static final String SINOPSE = "synopsis";
	public static final String NOTA = "score";

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
