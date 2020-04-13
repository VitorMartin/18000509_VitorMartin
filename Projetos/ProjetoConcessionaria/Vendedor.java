public class Vendedor{
    private double salarioBase, comissao;
    private Gerente gerente;

    public Vendedor(double salarioBase, Gerente gerente){
        this.gerente = gerente;
        this.salarioBase = salarioBase;
        this.comissao = 0.05; // 5% do total de vendas
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public double getComissao() {
        return comissao;
    }
    public double getSalarioDoMes(double totalVendasMes){
        return salarioBase + comissao * totalVendasMes;
    }
    public final Gerente getGerente() {
        return gerente;
    }
    public boolean setSalarioBase(double novoSalarioBase, Gerente gerente) {
        if(this.gerente.equals(gerente)){
            this.salarioBase = novoSalarioBase;
            return true;
        }
        else{
            return false;
        }
    }
}