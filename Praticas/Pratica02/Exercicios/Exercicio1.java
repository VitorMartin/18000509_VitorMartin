//Exercicio 1
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome, RA, telefone, email,idade;
        System.out.println("Informe seu RA: ");
        RA = scanner.nextLine();
        System.out.println("Informe seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Informe seu telefone: ");
        telefone = scanner.nextLine();
        System.out.println("Informe seu email: ");
        email = scanner.nextLine();
        System.out.println("Informe sua idade: ");
        idade = scanner.nextLine();

        //prints
        System.out.println("RA: " + RA);
        System.out.println("Nome: " + nome);
        System.out.println("telefone: " + telefone);
        System.out.println("email: " + email);
        System.out.println("idade " + idade);
        
    }
}

