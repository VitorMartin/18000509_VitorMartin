package br.maua.dao;

import br.maua.models.midia.Personagem;
import br.maua.throwables.EntradaNaoEncontradaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagensDAO implements DAO<Personagem> {
	private final String dbName = "personagens2";

	private Connection con;

	public PersonagensDAO() {
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
						res.getInt(MANA),
						res.getInt(ATK),
						res.getInt(ATKMAG),
						res.getInt(DEF),
						res.getInt(DEFMAG),
						res.getInt(VELOCIDADE),
						res.getInt(DESTREZA),
						res.getInt(XP),
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
				"INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (\"%s\", \"%s\", \"%s\", %d, %d, %d, %d, %d, %d, %d, %d, %d);",
				dbName,
				NOME, RACA, PROFISSAO, MANA, ATK, ATKMAG, DEF, DEFMAG, VELOCIDADE, DESTREZA, XP, NIVEL,
				personagem.getNome(), personagem.getRaca(), personagem.getProfissao(), personagem.getMana(), personagem.getAtk(), personagem.getAtkmag(), personagem.getDef(), personagem.getDefmag(), personagem.getVelocidade(), personagem.getDestreza(), personagem.getXP(), personagem.getNivel()
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
			if (nome.toLowerCase().equals(personagem.getNome().toLowerCase())) return personagem;
		}
		throw new EntradaNaoEncontradaException();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("====== PERSONAGENS =======\n");
		getAll().forEach(str::append);
		str.append("==========================\n");

		return str.toString();
	}
}
