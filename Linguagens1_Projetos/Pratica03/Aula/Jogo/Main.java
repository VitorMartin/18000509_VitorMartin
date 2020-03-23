import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gameMode;
        
        System.out.print("Modo de jogo [ppt/spock]: ");
        gameMode = scanner.nextLine();
        if(!(gameMode.equalsIgnoreCase(PPT.PPT) || gameMode.equalsIgnoreCase(Spock.SPOCK))){
            do{
            System.out.println("Modo de jogo invalido!");
            System.out.print("Modo de jogo [ppt/spock]: ");
            gameMode = scanner.nextLine();
            }
            while(!(gameMode.equalsIgnoreCase(PPT.PPT) || gameMode.equalsIgnoreCase(Spock.SPOCK)));
        }
        
        if (gameMode.equalsIgnoreCase(PPT.PPT)){
            PPT jogo = new PPT();
            System.out.println(jogo.getWinner() + " ganhou.");
        }
        else if(gameMode.equalsIgnoreCase(Spock.SPOCK)){
            Spock jogo = new Spock();
            System.out.println(jogo.getWinner() + " ganhou.");
        }
    }
}