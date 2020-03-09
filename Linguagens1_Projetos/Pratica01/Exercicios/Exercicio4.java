import java.util.Scanner;

public class Exercicio4{
     public static void main(String[] args) {
        //Declaracao
        Scanner scanner = new Scanner(System.in);
        String entrada;
        int i = 0;
        //Entrada de dados

        System.out.println("Digite uma frase ou palavra: ");
        entrada = scanner.nextLine();
        int t = entrada.length() - 1; // Tamanho da palavra/frase (o -1 serve para na hora de percorrer, a funcao comecar do endereco certo)
        boolean palindromo = true;
        //Percorrer a frase/palavra

        while (i <= t){
            if (entrada.charAt(i) != entrada.charAt(t)){
                palindromo = false;
            }
            i++; t--;
        }

        //Dizer se eh palindromo
    
       if (palindromo){
            System.out.println("Eh palindromo");
       }
       else{
           System.out.println("Nao eh palindromo");
       }
        
    }
}


