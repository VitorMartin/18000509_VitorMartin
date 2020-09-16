package br.maua.models;

import java.util.Scanner;

public class App {
	public void run(){
		Scanner sc = new Scanner(System.in);
		int inp = Menu.INVALIDO;
		String titulo = "";

		Menu.saudacao();

		while (inp != Menu.SAIR){
			Menu.inicio();

			try {
				inp = Integer.parseInt(sc.next());
			}catch (Exception e){
				inp = Menu.INVALIDO;
			}

			switch (inp){
				case Menu.ANIME:
					Menu.anime();
					titulo = sc.next();
					break;
				case Menu.MANGA:
					Menu.manga();
					titulo = sc.next();
					break;
				case Menu.SAIR:
					Menu.despedida();
					break;
				case Menu.INVALIDO:
					Menu.numeroDesconhecido();
					break;
				default:
					Menu.opcaoInvalida();
					break;
			}
		}
	}
}
