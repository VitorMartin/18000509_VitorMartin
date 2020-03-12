import java.util.Scanner;

public class EscolhaDeJogo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        System.out.println("Qual modo seseja jogar? [PPT / RPSLS]");
        String escolha = scanner.nextLine();

        if(escolha.equalsIgnoreCase("PPT")){
            PPT jogo = new PPT();
            jogo.jogar();
        }

        else{
            RPSLS jogo = new RPSLS();
            jogo.jogar();
        }

    }
}