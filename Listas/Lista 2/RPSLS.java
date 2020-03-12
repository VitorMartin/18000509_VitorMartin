public class RPSLS{
    String jogar(String j1, String j2){
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