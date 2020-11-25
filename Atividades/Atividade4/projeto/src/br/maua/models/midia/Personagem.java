package br.maua.models.midia;

/**
 * Classe que implementa um objeto de mídia. Contém as características de um mídia genérica, como título, sinopse, etc.
 */
public class Personagem {

	protected final int id;
	protected final String nome;
	protected final String raca;
	protected final String profissao;
	protected final double mana;
	protected final double atk;
	protected final double atkmag;
	protected final double def;
	protected final double defmag;
	protected final double velocidade;
	protected final double destreza;
	protected final double xp;
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
	public Personagem(int id, String nome, String raca, String profissao, double mana, double atk, double atkmag, double def, double defmag, double velocidade, double destreza, double xp, int nivel) {
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
	public Personagem(String nome, String raca, String profissao, double mana, double atk, double atkmag, double def, double defmag, double velocidade, double destreza, double xp, int nivel) {
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
	public double getMana() {
		return mana;
	}
	public double getAtk() {
		return atk;
	}
	public double getAtkmag() {
		return atkmag;
	}
	public double getDef() {
		return def;
	}
	public double getDefmag() {
		return defmag;
	}
	public double getVelocidade() {
		return velocidade;
	}
	public double getDestreza() {
		return destreza;
	}
	public double getXp() {
		return xp;
	}
	public int getNivel() {
		return nivel;
	}
}
