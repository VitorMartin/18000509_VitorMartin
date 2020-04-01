public class Funcionario{
    private double salarioBase, comissao;

    public Funcionario(double salarioBase){
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
}