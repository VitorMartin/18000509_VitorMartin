import java.util.Scanner;


public class EntradaDeDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.print("Informe seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Ola, " + nome);
    }    
}