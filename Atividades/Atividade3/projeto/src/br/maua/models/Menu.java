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

	public static void naoENumero(){
		System.out.println("O valor digitado nao e um numero.");
	}

	public static void foraDoRange(){
		System.out.println("O numero digitado esta fora do range entre 0 e 9");
	}

	public static void escolhaAnime(){
		System.out.println("Digite o titulo do seu Anime : ");
	}

	public static void escolhaManga(){
		System.out.println("Digite o titulo do seu Manga : ");
	}

	public static void mostrarTitulosEncontrados(String titulos){
		System.out.println("Digite o numero do titulo desejado:");
		System.out.println(titulos);
	}

	public static void opcaoInvalida(){
		System.out.println("Opcao invalida.");
	}

	public static void caracterIlegal() {
		System.out.println("Caractere ilegal utilizado na busca. Evite caracteres especiais.");
	}

	public static void erroDeSQL() {
		System.out.println("Erro de SQL.");
	}
}
