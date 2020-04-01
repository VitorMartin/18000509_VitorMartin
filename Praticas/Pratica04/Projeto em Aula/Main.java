public class Main{
    public static void main(String[] args){
        Conta c1 = new Conta(500);
        c1.depositar(1000);
        System.out.println("Saldo c1: " + c1.consultaSaldo());
        Conta c2 = new Conta(200);
        c2.depositar(1200);
        System.out.println("Saldo c2: " + c2.consultaSaldo());
    }
}
