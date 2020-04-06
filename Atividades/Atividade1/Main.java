// Vitor Martin Simoni - 18.00050-9
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        Usuario u1 = new Usuario("nome1", "email1", "senha1");
        Usuario u2 = new Usuario("nome2", "email2", "senha2");
        Usuario u3 = new Usuario("nome3", "email3", "senha3");

        Conta c1 = new Conta(u1);
        Conta c2 = new Conta(u2);
        Conta c3 = new Conta(u3);

        getInfo(c1, c2, c3);

        c1.depositar(1000);
        c2.depositar(250);
        c3.depositar(3000);

        getInfo(c1, c2, c3);

        String pedido1 = T.gerarQRCode(c1, 250);
        
        System.out.println(pedido1);

        T.transferir(c2, c1, pedido1);
        T.transferir(c3, c1, pedido1);
        T.transferir(c2, c1, pedido1);

        getInfo(c1, c2, c3);

        String pedido2 = T.gerarQRCode(c2, 1000);

        System.out.println(pedido2);

        T.transferir(c3, c2, pedido2);

        getInfo(c1, c2, c3);

        
    }



    public static void getInfo(Conta c1, Conta c2, Conta c3){
        System.out.println("----------------------------------------------------");
        System.out.println(c1.getInfo());
        System.out.println(c2.getInfo());
        System.out.println(c3.getInfo());
        System.out.println("----------------------------------------------------");
    }
}