package br.maua;

import br.maua.classes.Pedido;
import br.maua.classes.Usuario;
import br.maua.interfaces.Menu;
import br.maua.maps.Estados;
import br.maua.maps.Pagamentos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Menu {

    public static void main(String[] args) {

        // Variaveis
        String inp = "";
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Fazendo login
        Menu.login();
        String nome  = "conde"; //input("");
        String email = "email@domain"; //input("");
        String senha = "123456"; //input("");
        Usuario usr = new Usuario(nome, email, senha);
        Menu.saudacao(usr);
        System.out.println('\n');

        // Menu principal
        while (!inp.equals("9")){
            Menu.menuPrincipal();
            inp = input("");

            switch (inp){
                case "1":
                    if (!usr.isAdmin){
                        System.out.println("Voce nao possui nivel de Admin para criar novos pedidos.\n" +
                                           "Logue novamente com uma conta de Admin.");
                        break;
                    }
                    String descricao = input("Descricao: ");
                    Double valor = Double.parseDouble(input("Valor: "));
                    Menu.opcoesDePagamento();
                    String pagamento = Pagamentos.map.get(Integer.parseInt(input("")));
                    pedidos.add(new Pedido(descricao, valor, pagamento));
                    break;

                case "2":
                    Menu.mostrarPedidos(pedidos);
                    break;

                case "3":
                    if (!usr.isAdmin){
                        System.out.println("Voce nao possui nivel de Admin para alterar pedidos.\n" +
                                           "Logue novamente com uma conta de Admin.");
                        break;
                    }
                    String id = input("ID do pedido: ");
                    int indiceDoPedido = encontrarPedidoPorId(pedidos, id);
                    if (indiceDoPedido == -1){
                        System.out.println("ID nao encontrado.");
                        break;
                    }
                    Menu.opcoesDeEstado();
                    String novoEstado = Estados.map.get(Integer.parseInt(input("")));
                    pedidos.get(indiceDoPedido).mudarEstado(novoEstado);
                    break;

                case "9":
                    Menu.despedida();
                    break;

                default:
                    System.out.println("Comando nao reconhecido");
                    break;
            }
        }

    }

    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
//        scanner.close(); // Nao sei pq, mas se eu fechar o scanner, so posso chamar essa funcao UMA vez.
        return scanner.nextLine();
    }

    private static int encontrarPedidoPorId(ArrayList<Pedido> pedidos, String id){
        for (int i = 0; i < pedidos.size(); i++) {
            if (id.equals(pedidos.get(i).getId())){
                return i;
            }
        }
        return -1; // retorna -1 se nao encontrar o id
    }

}
