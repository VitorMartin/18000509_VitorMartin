package br.maua.models.cli;

import br.maua.api.Jikan;
import br.maua.models.App;

/**
 * Classe que cuida dos outputs do programa para o usuário. Tudo que for para mostrar ao usuário deverá
 * ser implementado por aqui.
 */
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
	/**
	 * Menu inciail.
	 */
	public static void inicio (){
		System.out.println(
				"-----------\n" +
						"Categorias:\n" +
						ANIME + " - Procurar anime" + "\n" +
						MANGA + " - Procurar manga"	+ "\n" +
						"\n" +
						EXIBIR + " - Exibir DB"	+ "\n" +
						PESQUISAR + " - Pesquisar DB"	+ "\n" +
						APAGAR + " - Apagar entrada"	+ "\n" +
						"\n" +
						SAIR + " - Sair" +
						"\n-----------"
		);
	}

	/**
	 * Saudação inicial ao usuário.
	 */
	public static void saudacao(){
		System.out.println("〜".repeat(37) + "\n" + "Seja bem-vindo ao OtakuDB! Escolha uma das opcoes a seguir:\n" + "〜".repeat(37));
	}

	/**
	 * Despedida ao usuário quando fechar a aplicação.
	 */
	public static void despedida(){
		System.out.println("〜".repeat(29) + "\n" + "Obrigado por utilizar o OtakuDB, volte sempre!\nArigato gozaimashita! (*＾▽＾)／" + "\n" + "〜".repeat(29));
	}

	/**
	 * Pergunta pelo título do Anime.
	 */
	public static void escolhaAnime(){
		System.out.println("Digite o titulo do seu Anime:");
	}

	/**
	 * Pergunta pelo título do Mangá.
	 */
	public static void escolhaManga(){
		System.out.println("Digite o titulo do seu Manga:");
	}

	/**
	 * Mostra todas as correspondências encontradas pela pesquisa na API.
	 *
	 * @param titulos {@link String} com todos os títulos encontrados, montado pelo método {@link Jikan#mostrarTitulosEncontrados()}.
	 */
	public static void mostrarTitulosEncontrados(String titulos){
		System.out.println("Digite o numero do titulo desejado:");
		System.out.println(titulos);
	}

	/**
	 * Pergunta se deseja utilizar a DB de Anime ou Mangá.
	 */
	public static void escolherDB() {
		System.out.printf("Qual DB deseja utilizar? [%d] Animes ou [%d] Mangas?\n", USAR_ANIME, USAR_MANGA);
	}

	/**
	 * Pergunta se deseja pesquisar por ID ou título.
	 */
	public static void escolherPesquisa(){
		System.out.printf("Como desejar realizar sua pesquisa? Por [%d] id ou [%d] titulo?\n", PESQUISAR_ID, PESQUISAR_TITULO);
	}

	/**
	 * Pede pelo ID.
	 */
	public static void digiteId(){
		System.out.println("Digite o ID a ser procurado:");
	}

	/**
	 * Pede pelo título.
	 */
	public static void digiteTitulo(){
		System.out.println("Digite o Titulo a ser procurado: (apenas match exato e nao importa upper case)");
	}

	/**
	 * Confirma se usuário deseja apagar entrada da DB.
	 */
	public static void confirmarApagar(){
		System.out.printf("Deseja apagar a seguinte midia? [%d] SIM ou [%d] NAO?\n", SIM, NAO);
	}

	// ========== Erros ========== \\
	/**
	 * Usuário digitou algo que não é número.
	 */
	public static void naoENumero(){
		System.out.println("O valor digitado nao e um numero.");
	}

	/**
	 * Usuário digitou número fora das opções fornecidas.
	 *
	 * Parâmetros podem ser null.
	 *
	 * Para determinar um limite máximo, mandar min como null e max como o limite.
	 *
	 * Para determinar um limite mínimo, mandar min como limite e max como null.
	 *
	 * Para determinar um limite mínimo e máximo, mandar min e max como os limites.
	 *
	 * @param min Valor mínimo aceito.
	 * @param max Valor máximo aceito.
	 */
	public static void foraDoRange(Integer min, Integer max){
		if (min == null) System.out.printf("O numero digitado deve ser menor que %d\n", max);
		else if (max == null) System.out.printf("O numero digitado deve ser maior que %d\n", min);
		else System.out.printf("O numero digitado deve ser entre %d e %d\n", min, max);
	}

	/**
	 * Caso default do switch case da classe {@link App#run()}.
	 *
	 * Acionado quando o número escolhido for válido, porém nenhuma opção de ação está associada.
	 */
	public static void opcaoInvalida(){
		System.out.println("Opcao invalida.");
	}

	/**
	 * Alerta se a pesquisa do usuário na API conter caracteres ilegais para a URI.
	 */
	public static void caracterIlegal() {
		System.out.println("Caractere ilegal utilizado na busca. Evite caracteres especiais.");
	}

	/**
	 * Entrada não encontrada na DB
	 */
	public static void entradaNaoEncontrada(){
		System.out.println("Entrada nao encontrada");
	}

	/**
	 * Erro de SQL ao tentar apagar entrada da DB.
	 */
	public static void falhaAoApagar(){
		System.out.println("Falha ao apagar entrada desejada.");
	}
}
