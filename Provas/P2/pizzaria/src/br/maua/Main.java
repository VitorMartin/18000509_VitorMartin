package br.maua;

import br.maua.funcionario.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String  nome = input("Nome: "),
                email = input("Email"),
                senha = input("Senha: ");
        Usuario usr = new Usuario(nome, email, senha);
        System.out.println(usr.toString());

    }

    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String inp = scanner.nextLine();
//        scanner.close(); // Nao sei pq, mas se eu fechar o scanner, so posso chamar essa funcao UMA vez.
        return inp;
    }
}
