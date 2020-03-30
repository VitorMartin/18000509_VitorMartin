import java.util.Scanner;


public class EntradaDeDados {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.print("Informe seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Ola, " + nome);

        int n1, n2;
        System.out.println("Informe dois numeros inteiros, separados por [ENTER]: ");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();

        System.out.println("Soma: " + (n1 + n2));
    }    
}