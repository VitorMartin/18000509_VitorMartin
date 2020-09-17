package br.maua.models;

import br.maua.api.Jikan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	private final Scanner sc = new Scanner(System.in);

	public void run(){
		int inp = Menu.INVALIDO;
		String titulo = "";
		Jikan jikan;

		Menu.saudacao();

		while (inp != Menu.SAIR){
			Menu.inicio();

			inp = pegarInput();

			switch (inp){
				case Menu.ANIME:
					Menu.escolhaAnime();
					titulo = sc.nextLine().toLowerCase();
					try {
						jikan = new Jikan(Jikan.ANIME, titulo);
						Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());
						inp = pegarInput();
					}
					catch (Exception e){
						e.printStackTrace();
						Menu.erroDeBusca();
					}
					break;

				case Menu.MANGA:
					Menu.escolhaManga();
					titulo = sc.nextLine().toLowerCase();
					try {
						jikan = new Jikan(Jikan.MANGA, titulo);
						Menu.mostrarTitulosEncontrados(jikan.mostrarTitulosEncontrados());
						inp = pegarInput();
					}
					catch (Exception e){
						e.printStackTrace();
						Menu.erroDeBusca();
					}
					break;

				case Menu.SAIR:
					Menu.despedida();
					break;

				default:
					Menu.opcaoInvalida();
					break;
			}
		}
	}

	private int pegarInput(){
		// Aceitar apenas valores entre 0 e 9

		int retorno = Menu.INVALIDO;

		while (retorno < 0 || retorno > 9) {
			try {
				retorno = sc.nextInt();
			} catch (InputMismatchException ignored) {
				Menu.foraDoRange();
			}

			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu
		}

		return retorno;
	}
}
