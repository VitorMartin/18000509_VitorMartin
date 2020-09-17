package br.maua.models.midia;

public class Manga extends Midia {

	private final int capitulos;
	private final int volumes;
	private final String tipo;

	public Manga(int id, String url, String titulo, String sinopse, int capitulos, int volumes, String tipo, double nota) {
		super(id, url, titulo, sinopse, nota);
		this.capitulos = capitulos;
		this.volumes = volumes;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String.format(
				"       ID : %s\n   Titulo : %s\n     Tipo : %s\n     Nota : %s\nCapitulos : %s\n  Volumes : %s\n      URL : %s\n  Sinopse : %s",
				id, titulo, tipo, nota, capitulos, volumes, url, sinopse
		);
	}
}
