import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command;

        System.out.println("Digite seu nick, email e senha.");
        String nick = sc.nextLine(), email = sc.nextLine(), senha = sc.nextLine();
        // String nick = "CmteVMS", email = "vms@domain.com", senha = "senha123";
        Usuario usr = new Usuario(nick, email, senha);

        Conta conta = new Conta(usr);

        Jogo jogo;

        System.out.println("Digite algum comando ou [help] para uma lista de comandos.");
        while (true) {
            command = sc.nextLine();
            System.out.println("--------------------");
            //USER COMMANDS ===================================
            if (command.equals("usr -c")) {
                System.out.println("Digite seu nick, email e senha.");
                nick = sc.nextLine();
                email = sc.nextLine();
                senha = sc.nextLine();
                usr = new Usuario(nick, email, senha);
                conta = new Conta(usr);
            }

            else if (command.equals("usr -i")) {
                System.out.println(usr.getInfo());
            }

            else if (command.equals("usr -e")) {
                System.out.println("Digite seu novo email.");
                String novoEmail = sc.nextLine();
                usr.setEmail(novoEmail);
            }

            // ACCOUNT COMMANDS ===================================
            else if (command.equals("acc -j")) {
                System.out.println("Digite o nome, o genero e a descricao do jogo.");
                String nome = sc.nextLine(), genero = sc.nextLine(), descricao = sc.nextLine();
                // String nome = "FFVI", genero = "RPG", descricao = "Jogo de RPG - REMAKE.";
                jogo = new Jogo(nome, genero, descricao);
                conta.addJogo(jogo);
            }

            else if (command.equals("acc -c")) {
                System.out.println("Quantos creditos deseja adicionar a sua conta?");
                double creditos = sc.nextDouble();
                
                conta.addCreditos(creditos);
            }

            else if (command.equals("acc -i")) {
                System.out.println(conta.getInfo());
            }
            
            // MENU COMMANDS ===================================
            else if (command.equals("help")) {
                menu();
            }

            else if (command.equals("exit")) {
                System.exit(0);
            }

            else {
                if (command.equals("")) {
                    continue;
                }
                else {
                    System.out.println("Comando invalido!");   
                }
            }

            System.out.println("--------------------");
        }
    }
    
    public static boolean menu(){
        System.out.println("usr -c (change user)\t, usr -e (change email)\t, usr -i (user info),\n" +
                           "acc -j (add game)\t, acc -c (add credits)\t,  acc -i (account info),\n" +
                           "help (show commands)\t, exit (stop program).");
        return true;
    }
}