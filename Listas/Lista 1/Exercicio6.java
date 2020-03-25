import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ini, fim;
        int i;
        int soma = 0; 
        int mult = 1;

        System.out.println("Digite o primeiro e o ultimo numero de uma sequencia: ");
        ini = scanner.nextInt();
        fim = scanner.nextInt();
        
        System.out.println("Numero inicial: " + ini + "\nNumero final: " + fim);

        for(i=ini ; i<=fim ; i++){
            soma = soma + i;
            mult = mult * i;
        }
        
        System.out.println("o somatorio eh: " + soma);
        System.out.println("A mult entre todos os valores eh: " + mult);
    }
    

        
}       