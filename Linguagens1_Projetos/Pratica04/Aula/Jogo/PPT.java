import java.util.Scanner;

public class PPT{
    public PPT(){
        Scanner scanner = new Scanner(System.in);
        String n1, n2, j1, j2;

        //NOME E JOGADA DO PLAYER 1
        System.out.print("Nome do player 1: ");
        n1 = scanner.nextLine();
        System.out.print("Jogada de " + n1 + " [pedra, papel, tesoura]: ");
        j1 = scanner.nextLine();
        if(!(j1.equalsIgnoreCase(PEDRA) || j1.equalsIgnoreCase(PAPEL) || j1.equalsIgnoreCase(TESOURA))){
            do{
            System.out.println("Jogada invalida!");
            System.out.print("Jogada de " + n1 + " [pedra, papel, tesoura]: ");
            j1 = scanner.nextLine();
            }
            while(!(j1.equalsIgnoreCase(PEDRA) || j1.equalsIgnoreCase(PAPEL) || j1.equalsIgnoreCase(TESOURA)));
        }

        //NOME E JOGADA DO PLAYER 2
        System.out.print("Nome do player 2: ");
        n2 = scanner.nextLine();
        System.out.print("Jogada de " + n2 + " [pedra, papel, tesoura]: ");
        j2 = scanner.nextLine();
        if(!(j2.equalsIgnoreCase(PEDRA) || j2.equalsIgnoreCase(PAPEL) || j2.equalsIgnoreCase(TESOURA))){
            do{
            System.out.println("Jogada invalida!");
            System.out.print("Jogada de " + n2 + " [pedra, papel, tesoura]: ");
            j2 = scanner.nextLine();
            }
            while(!(j2.equalsIgnoreCase(PEDRA) || j2.equalsIgnoreCase(PAPEL) || j2.equalsIgnoreCase(TESOURA)));
        }
        /////////////////////////////////////////////////////////////////
        Player p1 = new Player(n1, j1);
        Player p2 = new Player(n2, j2);

        if     ((p1.getChoice()).equalsIgnoreCase(p2.getChoice())){
            this.winner = "empate";
        }
        else if((p1.getChoice()).equalsIgnoreCase(PEDRA)   && p2.getChoice().equalsIgnoreCase(TESOURA) ||
                (p1.getChoice()).equalsIgnoreCase(PAPEL)   && p2.getChoice().equalsIgnoreCase(PEDRA)   ||
                (p1.getChoice()).equalsIgnoreCase(TESOURA) && p2.getChoice().equalsIgnoreCase(PAPEL)     ){
            this.winner =  p1.getName();
        }
        else{
            this.winner = p2.getName();
        }
    }

    public static final String PPT = "ppt";
    public static final String PEDRA = "pedra";
    public static final String PAPEL = "papel";
    public static final String TESOURA = "tesoura";

    private String winner;

    public String getWinner(){
        return this.winner;
    }
}