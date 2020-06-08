package Menu;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    
    public int getInp(){
        System.out.println(
            "\n" +
            "1 - Cadastrar novo membro\n" + 
            "2 - Apresentar membros cadastrados\n" + 
            "3 - Remover colaborador\n" + 
            "4 - Trocar jornada de trabalho\n" + 
            "5 - Postar mensagens\n" + 
            "9 - Sair"
        );
        return scanner.nextInt();
    }
}