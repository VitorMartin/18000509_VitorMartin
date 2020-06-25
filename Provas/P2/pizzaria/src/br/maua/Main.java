package br.maua;

import br.maua.classes.Pedido;
import br.maua.classes.Usuario;
import br.maua.interfaces.Menu;
import br.maua.maps.Estados;
import br.maua.maps.Pagamentos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe ponto de entrada da aplicação base.
 * <p>
 * Ela é responsável por iniciar e executar a aplicação,
 * mostrando os menus para o usuário, coletando sua interação
 * e agindo de acordo.
 *
 * @see Menu
 * @author Vitor Martin Simoni - 18.00050-9
 * @since 25/06/20
 */

public class Main implements Menu {

    /**
     * Função main.
     * @see Main
     * @param args Argumentos da main. Não utilizado.
     */
    public static void main(String[] args) {

        // Variaveis
        String inp = "";
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Fazendo login
        Menu.login();
        String nome  = input("Nome:");
        String email = input("Email:");
        String senha = input("Senha");
        Usuario usr = new Usuario(nome, email, senha);
        Menu.saudacao(usr);
        System.out.println('\n');

        // Menu principal
        while (!inp.equals("9")){
            Menu.menuPrincipal();
            inp = input("");

            switch (inp){
                // Criar novo pedido
                case "1":
                    // Checando se usuario é admin
                    if (!usr.isAdmin){
                        System.out.println("Voce nao possui nivel de Admin para criar novos pedidos.\n" +
                                           "Logue novamente com uma conta de Admin.");
                        break;
                    }
                    // Coletando informacoes do pedido
                    String descricao = input("Descricao: ");
                    Double valor = Double.parseDouble(input("Valor: "));
                    Menu.opcoesDePagamento();
                    String pagamento = Pagamentos.map.get(Integer.parseInt(input("")));
                    // Instanciando novo Pedido e adicionando-o no ArrayList pedidos
                    pedidos.add(new Pedido(descricao, valor, pagamento));
                    break;

                // Mostrar lista de pedidos
                case "2":
                    Menu.mostrarPedidos(pedidos);
                    break;

                // Alterar pedido da lista
                case "3":
                    // Checando se usuario é admin
                    if (!usr.isAdmin){
                        System.out.println("Voce nao possui nivel de Admin para alterar pedidos.\n" +
                                           "Logue novamente com uma conta de Admin.");
                        break;
                    }
                    // Coletando id do pedido e novo estado
                    String id = input("ID do pedido: ");
                    int indiceDoPedido = encontrarPedidoPorId(pedidos, id);
                    if (indiceDoPedido == -1){
                        System.out.println("ID nao encontrado.");
                        break;
                    }
                    Menu.opcoesDeEstado();
                    String novoEstado = Estados.map.get(Integer.parseInt(input("")));
                    // Mudando pedido
                    pedidos.get(indiceDoPedido).mudarEstado(novoEstado);
                    break;

                // Saindo do programa
                case "9":
                    Menu.despedida();
                    break;

                // Comando nao encontrado, nada acontece
                default:
                    System.out.println("Comando nao reconhecido");
                    break;
            }
        }

    }

    /**
     * Função para simplificar a coleta do que o usuário digitar.
     *
     * @param prompt Texto para mostrar ao usuário, antes de coletar seu input.
     *               Serve para dizer o que o input espera coletar.
     * @return Retorna o que o usuário digitou, em formato de String.
     */
    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        /*
         * Nao sei pq, mas se eu fechar o scanner, a funcao nao funciona. Erro dado:
         * Exception in thread "main" java.lang.IllegalStateException: Scanner closed
         */
//        scanner.close();

        return scanner.nextLine();
    }

    /**
     * Procura o pedido pelo ID e retorna seu índice no ArrayList pedidos
     *
     * @param pedidos ArrayList com todos os pedidos feitos.
     * @param id ID do pedido a ser procurado
     * @return Retorna o índice no ArrayList pedidos do pedido procurado.
     *         Se não encontrar, retorna -1.
     */
    private static int encontrarPedidoPorId(ArrayList<Pedido> pedidos, String id){
        for (int i = 0; i < pedidos.size(); i++) {
            if (id.equals(pedidos.get(i).getId())){
                return i;
            }
        }
        return -1; // retorna -1 se nao encontrar o id
    }

}
