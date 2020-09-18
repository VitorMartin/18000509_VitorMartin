package br.maua.models.cli;

public class Menu {
	public static final int ANIME = 1;

	public static final int MANGA = 2;

	public static final int EXIBIR = 3;

	public static final int USAR_ANIME = 1;
	public static final int USAR_MANGA = 2;

	public static final int PESQUISAR = 4;
	public static final int PESQUISAR_ID = 1;
	public static final int PESQUISAR_TITULO = 2;

	public static final int APAGAR = 5;
	public static final int SIM = 1;
	public static final int NAO = 2;

	public static final int SAIR = 9;

	public static final int INVALIDO = -1;

	// ========== Opcoes ========== \\
	public static void inicio (){
		System.out.println(
				"-----------\n" +
						"Categorias:\n" +
						ANIME + " - Anime" + "\n" +
						MANGA + " - Manga"	+ "\n" +
						EXIBIR + " - Exibir DB"	+ "\n" +
						PESQUISAR + " - Pesquisar"	+ "\n" +
						APAGAR + " - Apagar"	+ "\n" +
						"\n" +
						SAIR + " - Sair" +
						"\n-----------"
		);
	}

	public static void saudacao(){
		System.out.println("〜".repeat(37) + "\n" + "Seja bem-vindo ao OtakuDB! Escolha uma das opcoes a seguir:\n" + "〜".repeat(37));
	}

	public static void despedida(){
		System.out.println("〜".repeat(29) + "\n" + "Obrigado por utilizar o OtakuDB, volte sempre!\nArigato gozaimashita! (*＾▽＾)／" + "\n" + "〜".repeat(29));
	}

	public static void escolhaAnime(){
		System.out.println("Digite o titulo do seu Anime:");
	}

	public static void escolhaManga(){
		System.out.println("Digite o titulo do seu Manga:");
	}

	public static void mostrarTitulosEncontrados(String titulos){
		System.out.println("Digite o numero do titulo desejado:");
		System.out.println(titulos);
	}

	public static void escolherDB() {
		System.out.printf("Qual DB deseja utilizar? [%d] Animes ou [%d] Mangas?\n", USAR_ANIME, USAR_MANGA);
	}

	public static void escolherPesquisa(){
		System.out.printf("Como desejar realizar sua pesquisa? Por [%d] id ou [%d] titulo?\n", PESQUISAR_ID, PESQUISAR_TITULO);
	}

	public static void digiteId(){
		System.out.println("Digite o ID a ser procurado:");
	}

	public static void digiteTitulo(){
		System.out.println("Digite o Titulo a ser procurado: (apenas match exato e nao importa upper case)");
	}

	public static void confirmarApagar(){
		System.out.printf("Deseja apagar a seguinte midia? [%d] SIM ou [%d] NAO?\n", SIM, NAO);
	}

	// ========== Erros ========== \\
	public static void naoENumero(){
		System.out.println("O valor digitado nao e um numero.");
	}

	public static void foraDoRange(Integer min, Integer max){
		if (min == null) System.out.printf("O numero digitado deve ser menor que %d\n", max);
		else if (max == null) System.out.printf("O numero digitado deve ser maior que %d\n", min);
		else System.out.printf("O numero digitado deve ser entre %d e %d\n", min, max);
	}

	public static void opcaoInvalida(){
		System.out.println("Opcao invalida.");
	}

	public static void caracterIlegal() {
		System.out.println("Caractere ilegal utilizado na busca. Evite caracteres especiais.");
	}

	public static void entradaNaoEncontrada(){
		System.out.println("Entrada nao encontrada");
	}

	public static void falhaAoApagar(){
		System.out.println("Falha ao apagar entrada desejada.");
	}
}
