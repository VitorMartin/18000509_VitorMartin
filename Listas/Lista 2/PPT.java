public class PPT{
    void jogar(String j1, String j2){
        // EMPATE
        if     (j1.equalsIgnoreCase(j2))
            System.out.println("empate");

        // JOGADOR 1 GANHOU
        else if(j1.equalsIgnoreCase("pedra")   && j2.equalsIgnoreCase("tesoura") ||
                j1.equalsIgnoreCase("papel")   && j2.equalsIgnoreCase("pedra")   ||
                j1.equalsIgnoreCase("tesoura") && j2.equalsIgnoreCase("papel")     )
            System.out.println("jogador 1");

        // JOGADOR 2 GANHOU
        else
            System.out.println("jogador 2");
        
    }
}