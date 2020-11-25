package br.maua.dao;

import br.maua.models.midia.Manga;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangasDAO implements DAO<Manga> {
	private final String dbName = "mangas";

	private Connection con;

	public MangasDAO() {
		String dbConStr = "jdbc:sqlite:" + DBFileName;
		try {
			con = DriverManager.getConnection(dbConStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Manga> getAll() {
		List<Manga> mangas = new ArrayList<>();

		String comando = String.format("SELECT * FROM %s", dbName);

		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(comando);

			while (res.next()){
				Manga manga = new Manga(
						res.getInt(ID),
						res.getString(URL),
						res.getString(TITULO),
						res.getString(SINOPSE),
						res.getInt(CAPITULOS),
						res.getInt(VOLUMES),
						res.getString(TIPO),
						res.getDouble(NOTA)
				);
				mangas.add(manga);
			}

			res.close();

		}
		catch (SQLException e){
			e.printStackTrace();
		}

		return mangas;
	}

	@Override
	public void escreverEntrada(Manga manga) throws SQLException {
		String comando = String.format(
				"INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (%d, \"%s\", \"%s\", \"%s\", %d, %d, \"%s\", %s);",
				dbName,
				ID, URL, TITULO, SINOPSE, CAPITULOS, VOLUMES, TIPO, NOTA,
				manga.getId(), manga.getUrl(), manga.getTitulo().replace("\"", "'"), manga.getSinopse().replace("\"", "'"), manga.getCapitulos(), manga.getVolumes(), manga.getTipo(), manga.getNota()
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public void apagarEntrada(Manga manga) throws SQLException, NullPointerException {
		String comando = String.format(
				"DELETE FROM %s WHERE %s = %d;",
				dbName, ID, manga.getId()
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public Manga getEntradaPorID(int id) throws EntradaNaoEncontradaException {
		for (Manga manga : getAll()){
			if (id == manga.getId()) return manga;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public Manga getEntradaPorTitulo(String titulo) throws EntradaNaoEncontradaException {
		for (Manga manga : getAll()){
			if (titulo.equals(manga.getTituloLower())) return manga;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("====== MANGAS =======\n");
		getAll().forEach(str::append);
		str.append("=====================\n");

		return str.toString();
	}
}
