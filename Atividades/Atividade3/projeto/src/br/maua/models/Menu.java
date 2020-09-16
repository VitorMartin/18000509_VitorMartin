package br.maua.models;

public class Menu {
	public static final int ANIME = 1;
	public static final int MANGA = 2;
	public static final int SAIR = 9;
	public static final int INVALIDO = -1;

	public static void inicio (){
		System.out.println(
				"-----------\n" +
				"Categorias:\n" +
				ANIME + " - Anime" + "\n" +
				MANGA + " - Manga"	+ "\n" +
				"\n" +
				SAIR + " - Sair" +
				"\n-----------"
		);
	}

	public static void saudacao(){
		System.out.println("〜".repeat(37) + "\n" + "Seja bem-vindo ao OtakuDB! Escolha uma das opcoes a seguir:\n" + "〜".repeat(37));
	}

	public static void despedida(){
		System.out.println("〜".repeat(29) + "\n" + "Obrigado por utilizar o OtakuDB, volte sempre!\nArigato go sai masu! (*＾▽＾)／" + "\n" + "〜".repeat(29));
	}

	public static void numeroDesconhecido(){
		System.out.println("Numero desconhecido");
	}

	public static void anime(){
		System.out.println("Digite o titulo do seu Anime : ");
	}

	public static void manga(){
		System.out.println("Digite o titulo do se Manga : ");
	}

	public static void opcaoInvalida(){
		System.out.println("Opcao invalida.");
	}

	public static void erroDeBusca() {
		System.out.println("Erro de busca. Tente outra combinacao de categoria e titulo.");
	}
}
