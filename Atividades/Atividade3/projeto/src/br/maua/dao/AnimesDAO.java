package br.maua.dao;

import br.maua.models.midia.Anime;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimesDAO implements DAO<Anime> {
	private final String dbName = "animes";

	private Connection con;

	public AnimesDAO() {
		String dbConStr = "jdbc:sqlite:" + DBFileName;
		try {
			con = DriverManager.getConnection(dbConStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Anime> getAll() {
		List<Anime> animes = new ArrayList<>();

		String comando = String.format("SELECT * FROM %s", dbName);

		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(comando);

			while (res.next()){
				Anime anime = new Anime(
						res.getInt(ID),
						res.getString(URL),
						res.getString(TITULO),
						res.getString(SINOPSE),
						res.getInt(EPISODIOS),
						res.getDouble(NOTA)
				);
				animes.add(anime);
			}

			res.close();

		}
		catch (SQLException e){
			e.printStackTrace();
		}

		return animes;
	}

	@Override
	public void escreverEntrada(Anime anime) throws SQLException {
		String comando = String.format(
				"INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (%d, \"%s\", \"%s\", \"%s\", %d, %s);",
				dbName,
				ID, URL, TITULO, SINOPSE, EPISODIOS, NOTA,
				anime.getId(), anime.getUrl(), anime.getTitulo().replace("\"", "'"), anime.getSinopse().replace("\"", "'"), anime.getEpisodios(), anime.getNota()
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public void apagarEntrada(Anime anime) throws SQLException, NullPointerException {
		String comando = String.format(
				"DELETE FROM %s WHERE %s = %d;",
				dbName, ID, anime.getId()
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public Anime getEntradaPorID(int id) throws EntradaNaoEncontradaException {
		for (Anime anime : getAll()){
			if (id == anime.getId()) return anime;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public Anime getEntradaPorTitulo(String titulo) throws EntradaNaoEncontradaException {
		for (Anime anime : getAll()){
			if (titulo.equals(anime.getTituloLower())) return anime;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("====== ANIMES =======\n");
		getAll().forEach(str::append);
		str.append("=====================\n");

		return str.toString();
	}
}
