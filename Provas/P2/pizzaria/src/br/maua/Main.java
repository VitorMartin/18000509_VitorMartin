package br.maua;

import br.maua.cozinha.Pedido;
import br.maua.enumerates.Pagamento;
import br.maua.funcionario.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // TESTANDO USUARIO
//        String  nome = input("Nome: "),
//                email = input("Email"),
//                senha = input("Senha: ");
        String  nome = "conde",
                email = "email@domain",
                senha = "123456";
        Usuario usr = new Usuario(nome, email, senha);
        System.out.println(usr.toString());

        // TESTANDO PEDIDO
        Pedido pedido1 = new Pedido("Mucarela", Pagamento.CREDITO);
        Pedido pedido2 = new Pedido("Calabresa", Pagamento.VALE_ALIMENTACAO);
        Pedido pedido3 = new Pedido("Sabor inexistente", Pagamento.VALE_ALIMENTACAO);
        System.out.println(pedido1.toString());
        System.out.println(pedido2.toString());
        System.out.println(pedido3.toString());

    }

    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String inp = scanner.nextLine();
//        scanner.close(); // Nao sei pq, mas se eu fechar o scanner, so posso chamar essa funcao UMA vez.
        return inp;
    }
}
