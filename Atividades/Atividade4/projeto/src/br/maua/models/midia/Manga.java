package br.maua.models.midia;

/**
 * Classe filha de {@link Midia}, que implementa um objeto de mangá. Contém as características exclusivas de um mangá,
 * como número de capítulos e volumes.
 */
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
		StringBuilder str = new StringBuilder();

		str.append("----------|----------\n");
		str.append( String.format(
				"       ID : %s\n   Titulo : %s\n     Tipo : %s\n     Nota : %s\nCapitulos : %s\n  Volumes : %s\n      URL : %s\n  Sinopse : %s",
				id, titulo, tipo, nota, capitulos, volumes, url, sinopse
		));
		str.append("\n----------|----------\n");

		return str.toString();
	}

	//Getters e Setters
	public int getCapitulos() {
		return capitulos;
	}

	public int getVolumes() {
		return volumes;
	}

	public String getTipo() {
		return tipo;
	}
}
