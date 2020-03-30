public class Conta{
    //Atributos da classe
    public int id;
    public Cliente cliente;
    public double saldo;

    //Metodos da classe
    boolean sacar(double valor){
        if(this.saldo < valor){
            return false;
        }
        else{
            this.saldo -= valor;
            return true;
        }
    }

    void depositar(double valor){
        this.saldo += valor;
    }

    void visualizarSaldo(){
        System.out.println("Saldo da conta " + this.cliente.titular + ": " + this.saldo);
    }

    boolean transferirSaldo(Conta destino, double valor){
        if(sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        else{
            return false;
        }
    }
}
