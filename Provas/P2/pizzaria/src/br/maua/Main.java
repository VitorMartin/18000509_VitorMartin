package br.maua;

import br.maua.classes.Pedido;
import br.maua.enumerates.Estado;
import br.maua.classes.Usuario;
import br.maua.interfaces.Menu;
import br.maua.maps.Pagamentos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Menu {

    public static void main(String[] args) {

        // TESTANDO CONSTRUTOR DA CLASSE DO USUARIO
//        String  nome = input("Nome: "),
//                email = input("Email"),
//                senha = input("Senha: ");
//        String  nome = "conde",
//                email = "email@domain",
//                senha = "123456";
//        Usuario usr = new Usuario(nome, email, senha);
//        System.out.println(usr.toString());

        // TESTANDO AUTENTICACAO DE USUARIO
//        Usuario usrErrado = new Usuario("nome errado", "email@errado", "senha errada");
//        Usuario usrCerto = new Usuario("nome certo", "email@certo", "123456");
//        System.out.println(usrErrado.toString());
//        System.out.println(usrCerto.toString());

        // TESTANDO CONSTRUTOR DA CLASSE PEDIDO
//        Pedido pedido1 = new Pedido("1 refri, 1 calabresa", 30.52, Pagamento.CREDITO);
//        Pedido pedido2 = new Pedido("2 quatro queijos", 15., Pagamento.VALE_ALIMENTACAO);
//        Pedido pedido3 = new Pedido("3 brotinhos", 50., Pagamento.DINHEIRO);
//        System.out.println(pedido1.toString());
//        System.out.println(pedido2.toString());
//        System.out.println(pedido3.toString());

        // TESTANDO CRIAR NOVO PEDIDO NO ARRAYLIST
//        ArrayList<Pedido> pedidos = new ArrayList<>();
//        adicionarPedidoNaFila(pedidos, new Pedido("1 refri, 1 calabresa", 30.52, Pagamento.CREDITO));
//        adicionarPedidoNaFila(pedidos, new Pedido("2 quatro queijos", 15., Pagamento.VALE_ALIMENTACAO));
//        adicionarPedidoNaFila(pedidos, new Pedido("3 brotinhos", 50., Pagamento.DINHEIRO));
//        System.out.println(pedidosToString(pedidos));

        // TESTANDO MUDAR ESTADO DO PEDIDO
//        System.out.println(pedidosToString(pedidos));
//        String id = input("id: ");
//        Estado novoEstado = Estado.PREPARACAO;
//        mudarEstadoDoPedido(pedidos, id, novoEstado);
//        System.out.println(pedidosToString(pedidos));

        // ***** DESENVOLVENDO LOGICA DA INTERACAO COM O USUARIO ***** //

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
                    String descricao = input("Descricao: ");
                    Double valor = Double.parseDouble(input("Valor: "));
                    Menu.opcoesDePagamento();
                    String pagamento = Pagamentos.map.get(Integer.parseInt(input("")));
                    adicionarPedidoNaFila(pedidos, new Pedido(descricao, valor, pagamento));
                    break;

                case "2":
                    System.out.println("Mostrar");
                    break;

                case "3":
                    System.out.println("Alterar");
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
        String inp = scanner.nextLine();
//        scanner.close(); // Nao sei pq, mas se eu fechar o scanner, so posso chamar essa funcao UMA vez.
        return inp;
    }

    private static Boolean adicionarPedidoNaFila(ArrayList<Pedido> pedidos, Pedido pedido){
        return pedidos.add(pedido); // retorna true ou false se conseguiu adicionar Pedido na lista
    }

    private static Boolean mudarEstadoDoPedido(ArrayList<Pedido> pedidos, String id, Estado novoEstado){
        for (Pedido p : pedidos) {
            if (id.equals(p.getId())){
                p.mudarEstado(novoEstado);
                return true;
            }
        }
        return false; // retorna falso se nao encontrar id
    }

    private static String pedidosToString(ArrayList<Pedido> pedidos){
        String str = "ArrayList{\n";
        for (Object p : pedidos) {
            str += "          " + p.toString() + "\n";
        }
        str += '}';
        return str;
    }

}
