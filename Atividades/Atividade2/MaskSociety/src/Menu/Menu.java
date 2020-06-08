package Menu;

import java.util.Scanner;

public class Menu{
    private Scanner scanner = new Scanner(System.in);
    
    public int getInitialInp(){
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
    
      
    public String[] cadastrarMembro(){
        String cadastro[] = new String[3];
        scanner.nextLine();

        System.out.println("Nickname: ");
        cadastro[0] = scanner.nextLine();

        System.out.println("Email: ");
        cadastro[1] = scanner.nextLine();

        System.out.println(
            "Funcao:\n" +
            "1 - BigBrother\n" + 
            "2 - HeavyLifter\n" + 
            "3 - MobileMember\n" +
            "4 - ScriptGuys"
        );
        cadastro[2] = scanner.nextLine();
        
        return cadastro; //returning two values at once
    }

    public int mudarJornada(){
        System.out.println(
            "1 - Normal\n" + 
            "2 - Extra"
        );
        return scanner.nextInt();
    }
}