import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
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
                  (p1.jogada).equalsIgnoreCase("tesoura")   ));
        
        Jogador p2 = new Jogador();
        System.out.println("Nome do player 2: ");
        p2.nome = scanner.nextLine();
        do{
            System.out.println("Jogada do player 2: ");
            p2.jogada = scanner.nextLine();
        }while (!((p2.jogada).equalsIgnoreCase("pedra")   ||
                  (p2.jogada).equalsIgnoreCase("papel")   ||
                  (p2.jogada).equalsIgnoreCase("tesoura")   ));
        
    }
}