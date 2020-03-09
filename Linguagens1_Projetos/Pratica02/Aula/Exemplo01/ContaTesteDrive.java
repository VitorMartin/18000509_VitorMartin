public class ContaTesteDrive{
    public static void main(String[] args) {
        //Declara c1, ainda sem nada dentro (nullPointer)
        Conta c1;
        //Instancia Conta - coloca a referencia de um objeto
        c1 = new Conta();
        //Acessa o titular da conta
        c1.titular = "Odair";
        System.out.println("Titular: " + c1.titular);

        Conta c2 = new Conta();
        c2.titular = "Goku";
        System.out.println("Titular: " + c2.titular);
    }
}
