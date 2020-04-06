// Vitor Martin Simoni - RA 18.00050-9

public class Conta {
    private Usuario usr;
    private double saldo;
    private String idConta;

    private static int contador = 0;

    public Conta(Usuario usr){
        contador++;
        this.idConta = String.valueOf(contador);
        this.usr = usr;
        this.saldo = 0;
    }

    public boolean depositar(double valor){
        this.saldo += valor;

        return true;
    }

    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;

            return true;
        }

        else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    // public String pagar(Conta quemPaga, String code){

    //     if(this.saldo >= valor){

    //     }
        
    //     return "return receber";
    // }

    public String getID() {
        return idConta;
    }

    public String getNome(){
        return usr.getNome();
    }

    public double getSaldo() {
        return saldo;
    }

    public String getInfo(){
        return String.format("Usuario : %s, |\t| idConta : %s , \t saldo : %.2f", usr.getInfo(), this.idConta, this.saldo);
    }
}