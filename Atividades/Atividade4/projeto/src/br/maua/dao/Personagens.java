package br.maua.dao;

import br.maua.models.midia.Personagem;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Personagens implements DAO<Personagem> {
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
	public List<Personagem> getAll() {
		List<Personagem> personagens = new ArrayList<>();

		String comando = String.format("SELECT * FROM %s", dbName);

		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(comando);

			while (res.next()){
				Personagem personagem = new Personagem(
						res.getInt(ID),
						res.getString(NOME),
						res.getString(RACA),
						res.getString(PROFISSAO),
						res.getDouble(MANA),
						res.getDouble(ATK),
						res.getDouble(ATKMAG),
						res.getDouble(DEF),
						res.getDouble(DEFMAG),
						res.getDouble(VELOCIDADE),
						res.getDouble(DESTREZA),
						res.getDouble(XP),
						res.getInt(NIVEL)
				);
				personagens.add(personagem);
			}

			res.close();

		}
		catch (SQLException e){
			e.printStackTrace();
		}

		return personagens;
	}

	@Override
	public void escreverEntrada(Personagem personagem) throws SQLException {
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
	public void apagarEntrada(Personagem personagem) throws SQLException, NullPointerException {
		String comando = String.format(
				"DELETE FROM %s WHERE %s = %d;",
				dbName, personagem.getId()
		);

		PreparedStatement ps = con.prepareStatement(comando);

		ps.executeUpdate();
	}

	@Override
	public Personagem getEntradaPorID(int id) throws EntradaNaoEncontradaException {
		for (Personagem personagem : getAll()){
			if (id == personagem.getId()) return personagem;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public Personagem getEntradaPorNome(String nome) throws EntradaNaoEncontradaException {
		for (Personagem personagem : getAll()){
			if (nome.equals(personagem.getNome().toLowerCase())) return personagem;
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
