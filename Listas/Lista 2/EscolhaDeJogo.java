import java.util.Scanner;

public class EscolhaDeJogo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        do{
            System.out.println("Qual modo deseja jogar? [PPT / RPSLS]");
            escolha = scanner.nextLine();
        }while(!(escolha.equalsIgnoreCase("PPT")   ||
                 escolha.equalsIgnoreCase("RPSLS")   ));

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