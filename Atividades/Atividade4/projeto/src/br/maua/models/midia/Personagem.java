package br.maua.models.midia;

import java.util.ArrayList;

/**
 * Classe que implementa um objeto de mídia. Contém as características de um mídia genérica, como título, sinopse, etc.
 */
public class Personagem {

	protected final int id;
	protected final String nome;
	protected final String raca;
	protected final String profissao;
	protected final int mana;
	protected final int atk;
	protected final int atkmag;
	protected final int def;
	protected final int defmag;
	protected final int velocidade;
	protected final int destreza;
	protected final int xp;
	protected final int nivel;

	/**
	 * Construtor do objeto Personagem, com ID definido
	 * @param id
	 * @param nome
	 * @param raca
	 * @param profissao
	 * @param mana
	 * @param atk
	 * @param atkmag
	 * @param def
	 * @param defmag
	 * @param velocidade
	 * @param destreza
	 * @param xp
	 * @param nivel
	 */
	public Personagem(int id, String nome, String raca, String profissao, int mana, int atk, int atkmag, int def, int defmag, int velocidade, int destreza, int xp, int nivel) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.profissao = profissao;
		this.mana = mana;
		this.atk = atk;
		this.atkmag = atkmag;
		this.def = def;
		this.defmag = defmag;
		this.velocidade = velocidade;
		this.destreza = destreza;
		this.xp = xp;
		this.nivel = nivel;
	}

	/**
	 * Construtor do objeto Personagem, sem ID definido
	 * @param nome
	 * @param raca
	 * @param profissao
	 * @param mana
	 * @param atk
	 * @param atkmag
	 * @param def
	 * @param defmag
	 * @param velocidade
	 * @param destreza
	 * @param xp
	 * @param nivel
	 */
	public Personagem(String nome, String raca, String profissao, int mana, int atk, int atkmag, int def, int defmag, int velocidade, int destreza, int xp, int nivel) {
		this.id = -1;
		this.nome = nome;
		this.raca = raca;
		this.profissao = profissao;
		this.mana = mana;
		this.atk = atk;
		this.atkmag = atkmag;
		this.def = def;
		this.defmag = defmag;
		this.velocidade = velocidade;
		this.destreza = destreza;
		this.xp = xp;
		this.nivel = nivel;
	}

	/**
	 * Construtor do objeto Personagem, sem ID definido.
	 * @param dadosPersonagem Dados do personagem em formato de ArrayList
	 */
	public Personagem(ArrayList<String> dadosPersonagem) {
		this.id = -1;
		this.nome = dadosPersonagem.get(0);
		this.raca = dadosPersonagem.get(1);
		this.profissao = dadosPersonagem.get(2);
		this.mana = Integer.parseInt(dadosPersonagem.get(3));
		this.atk = Integer.parseInt(dadosPersonagem.get(4));
		this.atkmag = Integer.parseInt(dadosPersonagem.get(5));
		this.def = Integer.parseInt(dadosPersonagem.get(6));
		this.defmag = Integer.parseInt(dadosPersonagem.get(7));
		this.velocidade = Integer.parseInt(dadosPersonagem.get(8));
		this.destreza = Integer.parseInt(dadosPersonagem.get(9));
		this.xp = Integer.parseInt(dadosPersonagem.get(10));
		this.nivel = Integer.parseInt(dadosPersonagem.get(11));
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("----------|----------\n");
		str.append( String.format(
				"ID : %s\nNome : %s\nRaça : %s\nProfissao : %s\nMana : %s\nAtaque : %s\nAtaque Mágico : %s\nDefesa: %s\nDefesa Mágica : %s\nVelocidade : %s\nDestreza : %s\nExperiência : %s\nNível : %s",
				id, nome, raca, profissao, mana, atk, atkmag, def, defmag, velocidade, destreza, xp, nivel
		));
		str.append("\n----------|----------\n");

		return str.toString();
	}

	// Getters e Setters
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getRaca() {
		return raca;
	}
	public String getProfissao() {
		return profissao;
	}
	public int getMana() {
		return mana;
	}
	public int getAtk() {
		return atk;
	}
	public int getAtkmag() {
		return atkmag;
	}
	public int getDef() {
		return def;
	}
	public int getDefmag() {
		return defmag;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public int getDestreza() {
		return destreza;
	}
	public int getXP() {
		return xp;
	}
	public int getNivel() {
		return nivel;
	}
}
