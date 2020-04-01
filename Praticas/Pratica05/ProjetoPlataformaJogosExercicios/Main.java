import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String caminhoJogos = "./db/jogos.csv", caminhoUsr = "./db/usuario.csv", caminhoConta = "./db/conta.csv";
        String nick, email, senha;
        
        boolean usrExistir = false, criandoConta = false;

        String command = "";

        String row;
        String[] dbUsr = new String[3];
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(caminhoUsr));
            for (int i = 0; i < 3; i++) {
                row = csvReader.readLine();
                if (row != null) {
                    usrExistir = true;
                    dbUsr[i] = row.split(";")[1];
                } else {
                    usrExistir = false;
                    System.out.println("Nenhum usuario registrado.");
                    break;
                }
            }
            csvReader.close();
        }
        catch (Exception e) {
            usrExistir = false;
            System.out.println("./db/usuario.csv nao foi encontrado");
            System.out.println(e);
        }

        // Fazer login ou criar novo usuario
        if (usrExistir) {
            while (!(command.equals("l") || command.equals("n"))) {
                System.out.println("Deseja fazer login [l] ou criar novo usuario [n]? [l/n]");
                command = sc.nextLine();
            }
        }
        else {
            command = "n";
        }

        // usuario quer criar nova conta
        if (command.equals("n")) {
            criandoConta = true;
            System.out.println("Digite seu nick, email e senha para criar conta.");
            nick = sc.nextLine();
            email = sc.nextLine();
            senha = sc.nextLine();
        }
        // usuario existe e quer fazer login
        else if (command.equals("l") && usrExistir) {
            nick = dbUsr[0];
            email = dbUsr[1];
            senha = dbUsr[2];
        }
        // usuario quer fazer login e conta NAO existe --> criar nova conta
        else {
            criandoConta = true;
            System.out.println("Comando nao faz sentido. Digite seu nick, email e senha para criar nova conta.");
            nick = sc.nextLine();
            email = sc.nextLine();
            senha = sc.nextLine();
        }
        Usuario usr = new Usuario(nick, email, senha);

        // Fazendo login
        if (!criandoConta) {
            String tentativaNick = "", tentativaSenha = "";
            while (!usr.loginCorreto(tentativaNick, tentativaSenha)) {
                System.out.println("Digite seu nick e senha.");
                tentativaNick = sc.nextLine();
                tentativaSenha = sc.nextLine();
            }
        }

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
                try {
                    FileWriter fw = new FileWriter("Informacoes_da_conta.csv");
                    fw.write(conta.getInfoAsCSV());
                    fw.close();
                } 
                catch (Exception e) {
                    System.out.println(e);
                }
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
    
    public static boolean menu() {
        System.out.println("usr -c (change user)\t, usr -e (change email)\t, usr -i (user info),\n"
                + "acc -j (add game)\t, acc -c (add credits)\t,  acc -i (account info),\n"
                + "help (show commands)\t, exit (stop program).");
        return true;
    }
}