import java.util.Scanner;
import java.lang.Math;

public class Exercicio5{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num;
    long fib;
    //Entrada de dados
    System.out.println("Digite o numero desejado da sequencia (maximo 92): ");
    num = scanner.nextInt();

    fib = Math.round(Math.pow((Math.sqrt(5) + 1) / 2, num) / Math.sqrt(5));

    System.out.println("O " + num + ". numero de Fibonacci eh: " + fib + ".");
    }
}