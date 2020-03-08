import java.util.Scanner;

public class Exercicio3{
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       //Declaracao de varaiaveis

       String usuario, senha, usarion, senhan;

       //Criacao de usuario e senha

       System.out.println("Escolha seu nome de usuario: ");
       usuario = scanner.nextLine();
       System.out.println("Digite sua senha: ");
       senha = scanner.nextLine();

       //Teste de validade

       do{
             
       System.out.println("Digite usuario: ");
       usarion = scanner.nextLine();
       System.out.println("Digite senha: ");
       senhan = scanner.nextLine();

       //mensagem de erro
       if((!usarion.equals(usuario)) || (!senhan.equals(senha))){
           System.out.println("Voce errou usuario ou senha!");
       }

       } while((!usarion.equals(usuario)) || (!senhan.equals(senha)));

    }
}