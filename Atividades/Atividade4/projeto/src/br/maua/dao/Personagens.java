package br.maua.dao;

import br.maua.models.midia.Anime;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Personagens implements DAO<Anime> {
	private final String dbName = "personagens";

	private Connection con;

	public Personagens() {
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
//				Anime anime = new Anime(
//						res.getString(NOME),
//						res.getString(RACA),
//						res.getString(PROFISSAO),
//						res.getInt(EPISODIOS),
//						res.getDouble(MANA)
//				);
//				animes.add(anime);
				System.out.println(res);
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
				"INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (%d, \"%s\", \"%s\", \"%s\", %d, %s);",
				dbName,
				NOME, RACA, PROFISSAO, MANA, ATK, ATKMAG, DEF, DEFMAG, VELOCIDADE, DESTREZA, XP, NIVEL,
				"NOME", "RACA", "PROFISSAO", "MANA", "ATK", "ATKMAG", "DEF", "DEFMAG", "VELOCIDADE", "DESTREZA", "XP", "NIVEL"
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public void apagarEntrada(Anime anime) throws SQLException, NullPointerException {
		String comando = String.format(
				"DELETE FROM %s WHERE %s = %d;",
				dbName, anime.getId()
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
	public Anime getEntradaPorNome(String nome) throws EntradaNaoEncontradaException {
		for (Anime anime : getAll()){
			if (nome.equals(anime.getTituloLower())) return anime;
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
