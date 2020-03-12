import java.util.Scanner;

public class RPSLS{
    void jogar(){
        Scanner scanner = new Scanner(System.in);
        PPT ppt = new PPT();
        
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
        if     (j1.equalsIgnoreCase(j2))
            return "empate";

        // JOGADOR 1 GANHOU
        else if(j1.equalsIgnoreCase("pedra")   && j2.equalsIgnoreCase("tesoura") ||
                j1.equalsIgnoreCase("papel")   && j2.equalsIgnoreCase("pedra")   ||
                j1.equalsIgnoreCase("tesoura") && j2.equalsIgnoreCase("papel")   ||
                j1.equalsIgnoreCase("pedra") && j2.equalsIgnoreCase("lizard")    ||
                j1.equalsIgnoreCase("papel") && j2.equalsIgnoreCase("spock")     ||
                j1.equalsIgnoreCase("tesoura") && j2.equalsIgnoreCase("lizard")  ||
                j1.equalsIgnoreCase("lizard") && j2.equalsIgnoreCase("papel")    ||
                j1.equalsIgnoreCase("lizard") && j2.equalsIgnoreCase("spock")    ||
                j1.equalsIgnoreCase("spock") && j2.equalsIgnoreCase("pedra")     ||
                j1.equalsIgnoreCase("spock") && j2.equalsIgnoreCase("tesoura")     )
            return "jogador 1";

        // JOGADOR 2 GANHOU
        else
            return "jogador 2";
        
    }
}