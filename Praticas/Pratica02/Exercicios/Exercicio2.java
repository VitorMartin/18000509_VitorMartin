import java.util.Scanner;

public class Exercicio2{
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       //declaracao de variaveis
       String nome1,nome2;
       int idade1,idade2,dif;

       //Pedir nomes e idades
        System.out.println("Digite seus nomes: ");
        nome1 = scanner.nextLine();
        nome2 = scanner.nextLine();
        System.out.println("Digite suas idades: ");
        idade1 = scanner.nextInt();
        idade2 = scanner.nextInt();
        
        //Comparacao entre as idades
        if (idade1 >= idade2){
            dif = idade1 - idade2;
        }
        else{
            dif = idade2 - idade1;
        }
        System.out.println("A diferenca eh: " +dif);

       }
    
       

   }
