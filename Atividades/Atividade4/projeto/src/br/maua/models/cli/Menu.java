package br.maua.models.cli;

import br.maua.models.App;

/**
 * Classe que cuida dos outputs do programa para o usuário. Tudo que for para mostrar ao usuário deverá
 * ser implementado por aqui.
 */
public class Menu {
	public static final int CRIAR = 1;
	public static final int EXIBIR = 2;
	public static final int PESQUISAR = 3;
	public static final int APAGAR = 4;

	public static final int PESQUISAR_ID = 1;
	public static final int PESQUISAR_NOME = 2;

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
						CRIAR + " - Criar personagem" + "\n" +
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
		System.out.println("〜".repeat(37) + "\n" + "Seja bem-vindo ao RPG DEV! Escolha uma das opcoes a seguir:\n" + "〜".repeat(37));
	}

	/**
	 * Despedida ao usuário quando fechar a aplicação.
	 */
	public static void despedida(){
		System.out.println("〜".repeat(29) + "\n" + "Obrigado por utilizar o RPG DEV, volte sempre!\nArigato gozaimashita! (*＾▽＾)／" + "\n" + "〜".repeat(29));
	}

	/**
	 * Pergunta pelo nome do personagem.
	 */
	public static void criarNome(){
		System.out.println("Digite o nome do personagem a ser criado:");
	}

	/**
	 * Coleta dados do personagem a ser criado. O nome já foi determinado anteriormente
	 */
	public static void criarDadosPersonagem(){
		System.out.println("Digite os dados solicitados, separados por VÍRGULA E SEM ESPAÇO:");
		System.out.println("Raça, profissão, mana, ataque, ataque mágico, defesa, defesa mágica, velocidade, destreza, experiência e nível atual");
	}

	/**
	 * Pergunta se deseja pesquisar por ID ou nome.
	 */
	public static void escolherPesquisa(){
		System.out.printf("Como desejar realizar sua pesquisa? Por [%d] ID ou [%d] nome?\n", PESQUISAR_ID, PESQUISAR_NOME);
	}

	/**
	 * Pede pelo ID.
	 */
	public static void digiteId(){
		System.out.println("Digite o ID a ser procurado:");
	}

	/**
	 * Pede pelo nome.
	 */
	public static void digiteNome(){
		System.out.println("Digite o nome a ser procurado: (apenas match exato e nao importa upper case)");
	}

	/**
	 * Mensagem para quando o personagem já existir na databse
	 */
	public static void entradaJaExiste() {
		System.out.println("Esse personagem já existe!\n");
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
