import java.util.Scanner;

public class RPSLS{
    void jogar(){
        Scanner scanner = new Scanner(System.in);
        
        Jogador p1 = new Jogador();
        System.out.println("Nome do player 1: ");
        p1.nome = scanner.nextLine();
        do{
            System.out.println("Jogada do player 1: ");
            p1.jogada = scanner.nextLine();
        }while (!((p1.jogada).equalsIgnoreCase("pedra")   ||
                  (p1.jogada).equalsIgnoreCase("papel")   ||
                  (p1.jogada).equalsIgnoreCase("tesoura") ||
                  (p1.jogada).equalsIgnoreCase("lizard")  ||
                  (p1.jogada).equalsIgnoreCase("spock")     ));
        
        Jogador p2 = new Jogador();
        System.out.println("Nome do player 2: ");
        p2.nome = scanner.nextLine();
        do{
            System.out.println("Jogada do player 2: ");
            p2.jogada = scanner.nextLine();
        }while (!((p2.jogada).equalsIgnoreCase("pedra")   ||
                  (p2.jogada).equalsIgnoreCase("papel")   ||
                  (p2.jogada).equalsIgnoreCase("tesoura") ||
                  (p1.jogada).equalsIgnoreCase("lizard")  ||
                  (p1.jogada).equalsIgnoreCase("spock")     ));
        
        // EMPATE
        if     ((p1.jogada).equalsIgnoreCase(p2.jogada))
            System.out.println("Empate! Muito bom! Uma estrela!");

        // JOGADOR 1 GANHOU
        else if((p1.jogada).equalsIgnoreCase("pedra")   && (p2.jogada).equalsIgnoreCase("tesoura") ||
                (p1.jogada).equalsIgnoreCase("papel")   && (p2.jogada).equalsIgnoreCase("pedra")   ||
                (p1.jogada).equalsIgnoreCase("tesoura") && (p2.jogada).equalsIgnoreCase("papel")   ||
                (p1.jogada).equalsIgnoreCase("pedra")   && (p2.jogada).equalsIgnoreCase("lizard")    ||
                (p1.jogada).equalsIgnoreCase("papel")   && (p2.jogada).equalsIgnoreCase("spock")     ||
                (p1.jogada).equalsIgnoreCase("tesoura") && (p2.jogada).equalsIgnoreCase("lizard")  ||
                (p1.jogada).equalsIgnoreCase("lizard")  && (p2.jogada).equalsIgnoreCase("papel")    ||
                (p1.jogada).equalsIgnoreCase("lizard")  && (p2.jogada).equalsIgnoreCase("spock")    ||
                (p1.jogada).equalsIgnoreCase("spock")   && (p2.jogada).equalsIgnoreCase("pedra")     ||
                (p1.jogada).equalsIgnoreCase("spock")   && (p2.jogada).equalsIgnoreCase("tesoura")     )
            System.out.println(p1.nome + " gahou!");

        // JOGADOR 2 GANHOU
        else
            System.out.println(p2.nome + " ganhou!");
        
    }
}