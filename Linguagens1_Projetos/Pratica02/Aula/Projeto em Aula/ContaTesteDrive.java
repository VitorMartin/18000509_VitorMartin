public class ContaTesteDrive{
    public static void main(String[] args) {
        //Declara c1, ainda sem nada dentro (nullPointer)
        Conta c1;
        //Instancia Conta - coloca a referencia de um objeto
        c1 = new Conta();
        //Acessa o titular da conta
        // c1.titular = "Odair";
        c1.cliente = new Cliente();
        c1.cliente.titular = "Odair";
        System.out.println("Titular da c1: " + c1.cliente.titular);

        Conta c2 = new Conta();
        // c2.titular = "Goku";
        c2.cliente = new Cliente();
        c2.cliente.titular = "Goku";
        System.out.println("Titular da c2: " + c2.cliente.titular);

        System.out.println("==========================");

        c1.saldo = 2000;
        c1.visualizarSaldo();
        c1.sacar(300);
        c1.visualizarSaldo();
        System.out.println("----------");
        c1.sacar(1000000);
        System.out.println(c1.sacar(1000000));
        c1.visualizarSaldo();

        System.out.println("==========================");

        c1.visualizarSaldo();
        c2.visualizarSaldo();
        c1.transferirSaldo(c2, 500);
        c1.visualizarSaldo();
        c2.visualizarSaldo();
        System.out.println("----------");
        c1.visualizarSaldo();
        c2.visualizarSaldo();
        c1.transferirSaldo(c2, 1000000);
        c1.visualizarSaldo();
        c2.visualizarSaldo();
    }
}
