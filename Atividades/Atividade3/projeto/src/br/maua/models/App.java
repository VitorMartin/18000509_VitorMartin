package br.maua.models;

import java.util.Scanner;

public class App {
	public void run(){
		Scanner sc = new Scanner(System.in);
		int inp = -1;

		Menu.saudacao();

		while (inp != Menu.SAIR){
			Menu.inicio();
			inp = sc.nextInt();
		}

		Menu.despedida();
	}
}
