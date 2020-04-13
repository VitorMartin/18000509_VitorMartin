public class Gerente{
    private double salarioBase, comissao;

    public Gerente(double salarioBase){
        this.salarioBase = salarioBase;
        this.comissao = 0.1; // 5% do total de vendas
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
    public boolean darAumento(Vendedor vendedor, double aumento){
        double novoSalarioBase = vendedor.getSalarioBase() * (1.0 + aumento);
        return vendedor.setSalarioBase(novoSalarioBase, this);
    }
}