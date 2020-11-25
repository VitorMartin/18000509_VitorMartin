package br.maua.models.cli;

import br.maua.throwables.ForaDoRangeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	private final Scanner sc = new Scanner(System.in);
	private int menu = Menu.INVALIDO;
	private int db = Menu.INVALIDO;
	private int pesquisa = Menu.INVALIDO;
	private int id = Menu.INVALIDO;
	private int apagar = Menu.NAO;
	private String titulo = "";

	/**
	 * Valida input do usuário maior que 0.
	 *
	 * @return Input do usuário validado.
	 */
	private int getInputPositivo(){ // input > 0
		int retorno = Menu.INVALIDO;

		while ( retorno <= 0 ) {
			try {
				retorno = sc.nextInt();
				if ( retorno <= 0 ) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange(0, null);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	/**
	 * Valida input do usuário entre 0 e 9 (intervalos fechados).
	 *
	 * @return Input do usuário validado.
	 */
	private int getInputEntre0e9(){ // 0 <= input <= 9
		int retorno = Menu.INVALIDO;

		while (notEntre0e9(retorno)) {
			try {
				retorno = sc.nextInt();
				if (notEntre0e9(retorno)) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange(0, 9);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	/**
	 * Valida input do usuário igual a 1 ou 2.
	 *
	 * @return Input do usuário validado.
	 */
	private int getInputEntre1e2(){ // input = 1 ou 2
		int retorno = Menu.INVALIDO;

		while (notEntre1e2(retorno)) {
			try {
				retorno = sc.nextInt();
				if (notEntre1e2(retorno)) throw new ForaDoRangeException();
			}
			catch (InputMismatchException ignored) {
				Menu.naoENumero();
			}
			catch (ForaDoRangeException ignored){
				Menu.foraDoRange(1, 2);
			}
			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}

	/**
	 * Verifica se input não está entre 0 e 9 (intervalos fechados).
	 *
	 * @param x Input.
	 * @return Verdadeiro se input não está entre 0 e 9 (intervalos fechados).
	 */
	private boolean notEntre0e9(int x){
		return x < 0 || x > 9;
	}

	/**
	 * Verifica se input é diferente de 1 ou 2.
	 *
	 * @param x Input.
	 * @return Verdadeiro se input for diferente de 1 ou 2.
	 */
	private boolean notEntre1e2(int x){
		return x < 1 || x > 2;
	}

	// Getters e Setters
	public int getMenu() {
		return menu;
	}
	public int getDB() {
		return db;
	}
	public int getPesquisa() {
		return pesquisa;
	}
	public int getID() {
		return id;
	}
	public int getApagar() {
		return apagar;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setMenu() {
		this.menu = getInputEntre0e9();
	}
	public void setDB() {
		this.db = getInputEntre1e2();
	}
	public void setPesquisa() {
		this.pesquisa = getInputEntre1e2();
	}
	public void setID() {
		this.id = getInputPositivo();
	}
	public void setApagar() {
		this.apagar = getInputEntre1e2();
	}
	public void setTitulo() {
		this.titulo = sc.nextLine().toLowerCase();
	}
}
