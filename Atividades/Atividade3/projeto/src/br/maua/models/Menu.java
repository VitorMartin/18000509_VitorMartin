package br.maua.models;

public class Menu {
	public static int ANIME = 1;
	public static int MANGA = 2;
	public static int SAIR = 9;

	public static void inicio (){
		System.out.println(
				"\n" +
				"---------\n" +
				ANIME + " - Anime" + "\n" +
				MANGA + " - Manga"	+ "\n" +
				"\n" +
				SAIR + " - Sair" +
				"\n---------"
		);
	}

	public static void saudacao(){
		System.out.println("\n" + "〜".repeat(37) + "\n" + "Seja bem-vindo ao OtakuDB! Escolha uma das opcoes a seguir:\n" + "〜".repeat(37) + "\n");
	}

	public static void despedida(){
		System.out.println("\n" + "〜".repeat(29) + "\n" + "Obrigado por utilizar o OtakuDB, volte sempre!\nArigato go sai masu! (*＾▽＾)／" + "\n" + "〜".repeat(29));
	}
}
