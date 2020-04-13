public class RH{
    public static void rodarRH(){
        Gerente g1, g2;
        Vendedor v1, v2;
        double totalVendasMes = 1000;
        g1 = new Gerente(1000);
        v1 = new Vendedor(1000, g1);
        System.out.println("Gerente 1: " + g1.getSalarioDoMes(totalVendasMes));
        System.out.println("Vendedor1: " + v1.getSalarioDoMes(totalVendasMes));
        g1.darAumento(v1, 0.1);
        if(g1.darAumento(v1, 0.1))
            System.out.println("Deu certo");
        System.out.println("Vendedor1: " + v1.getSalarioDoMes(totalVendasMes));
    }
}