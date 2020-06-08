import Menu.Menu;

//Daniel Ughini Xavier RA:18.00022-3
//Vitor Martin Simoni RA:18.00050-9


public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        int inp;
        do {
            inp = menu.getInp();
            switch (inp) {
                case 1:
                    // Cadastrar novo membro
                    break;

                case 2:
                    // Apresentar membros
                    break;

                case 3:
                    // Remover colaborador
                    break;

                case 4:
                    // Trocar jornada de trabalho
                    break;

                case 5:
                    // Postar mensagens

                case 9:
                    // Sair
                    break;
            
                default:
                    break;
            }
        } while (inp != 9);
    }
}
