import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int i;
        int soma = 0;
        System.out.println("Digite um numero: ");
        num = scanner.nextInt();

        while(num > 0){
            soma = soma + (num % 10);
            num = (num/10);
        } 
        System.out.println("A soma de seus algarismos eh: " + soma);
    }
}