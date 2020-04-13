import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome, genero, descricao;
        // System.out.println("Informe dados do jogo (nome, genero e descricao):");
        // nome = scanner.nextLine();
        // genero = scanner.nextLine();
        // descricao = scanner.nextLine();
        nome = "Final Fantasy VII";
        genero = "RPG";
        descricao = "Jogo de RPG.";

        Jogo j1 = new Jogo(nome, genero, descricao);
        System.out.println("J1: " + j1.getInfo());

        System.out.println("Informe nickname:");
        String nick = scanner.nextLine();
        Usuario usuario = new Usuario(nick, "senha", "email");
        Conta conta = new Conta(usuario);
        System.out.println(conta.getInfo());
        conta.addCreditos(50);
        conta.addJogo(j1);
        System.out.println(conta.getInfo());

        scanner.close();
    }
}