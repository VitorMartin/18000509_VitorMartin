public class Conta{
    public Conta(double saldoInicial){
        this.saldo = saldoInicial;
    }

    private double saldo;
    public void sacar(double valor){
        if(valor <= saldo)
            saldo -= valor;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public double consultaSaldo(){
        return this.saldo;
    }
}
