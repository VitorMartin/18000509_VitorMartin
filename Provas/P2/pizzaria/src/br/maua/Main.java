package br.maua;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String a = input("str a: ");
        String b = input("str b: ");

        System.out.println(a);
        System.out.println(b);

    }

    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String inp = scanner.nextLine();
//        scanner.close(); // Nao sei pq, mas se eu fechar o scanner, so posso chamar essa funcao UMA vez.
        return inp;
    }
}
