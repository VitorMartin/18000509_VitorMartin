//Daniel Ughini Xavier RA:18.00022-3
//Vitor Martin Simoni RA:18.00050-9

import java.util.ArrayList;
import java.util.Scanner;

import Enums.Horarios;
import Funcionario.Funcionario;
import Menu.Menu;
import Models.BigBrother;
import Models.HeavyLifter;
import Models.MobileMember;
import Models.ScriptGuy;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList();
        Horarios horario = Horarios.NORMAL;
        int inp1;
        do {
            inp1 = menu.getInitialInp();
            switch (inp1) {
                case 1:
                    // Cadastrar novo membro
                    String cadastro[] = new String[3];

                    cadastro = menu.cadastrarMembro();
                    String nick = cadastro[0], email = cadastro[1];
                    int func = Integer.parseInt(cadastro[2]);

                    switch (func) {
                        case 1:
                            funcionarios.add(new BigBrother(nick, email, "BigBrother"));
                            break;

                        case 2:
                            funcionarios.add(new HeavyLifter(nick, email, "HeavyLifter"));
                            break;
                        
                        case 3:
                            funcionarios.add(new MobileMember(nick, email, "MobileMember"));
                            break;

                        case 4:
                            funcionarios.add(new ScriptGuy(nick, email, "ScriptGuy"));
                            break;
                    
                        default:
                            break;
                    }
                    break;

                case 2:
                    // Apresentar membros
                    for (Funcionario funcionario : funcionarios) {
                        funcionario.show();
                    }
                    break;

                case 3:
                    // Remover colaborador
                    for (int i = 0; i < funcionarios.size(); i++) {
                        System.out.println(i + " - " + funcionarios.get(i).getNick());
                    }
                    funcionarios.remove(scanner.nextInt());
                    break;

                case 4:
                    // Trocar jornada de trabalho
                    int inp2 = menu.mudarJornada();
                    if (inp2 == 1)
                        horario = Horarios.NORMAL;
                    else if (inp2 == 2)
                        horario = Horarios.EXTRA;
                    break;

                case 5:
                    // Postar mensagens
                    for (Funcionario funcionario : funcionarios) {
                        if (horario == Horarios.NORMAL) {
                            funcionario.msgNormal();
                        }
                        else {
                            funcionario.msgExtra();
                        }
                    }
                case 9:
                    // Sair
                    break;

                default:
                    break;
            }
            System.out.println("Aperte ENTER para continuar");
            scanner.nextLine();
        } while (inp1 != 9);
    }
}
