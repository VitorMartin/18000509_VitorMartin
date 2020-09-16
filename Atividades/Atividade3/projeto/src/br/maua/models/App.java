package br.maua.models;

import br.maua.api.Jikan;
import org.json.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public void run(){
		Scanner sc = new Scanner(System.in);
		int inp = Menu.INVALIDO;
		String titulo = "";
		JSONObject resp;

		Menu.saudacao();

		while (inp != Menu.SAIR){
			Menu.inicio();

			try {
				inp = sc.nextInt();
			}catch (InputMismatchException e){
				inp = Menu.INVALIDO;
			}

			sc.nextLine(); // consumindo o "\n" que o sc.nextInt() nao consumiu

			switch (inp){
				case Menu.ANIME:
					Menu.anime();
					titulo = sc.nextLine();
					try {
						Jikan.request(Jikan.ANIME, titulo);
					}catch (Exception e){
						e.printStackTrace();
						Menu.erroDeBusca();
					}
					break;

				case Menu.MANGA:
					Menu.manga();
					titulo = sc.nextLine();
					try {
						Jikan.request(Jikan.MANGA, titulo);
					}catch (Exception e){
						e.printStackTrace();
						Menu.erroDeBusca();
					}
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
