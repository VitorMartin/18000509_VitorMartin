package Naruto;

public class Ninja {
    private String name;
    private String family;
    private String[] jutsus;

    public Ninja(String name, String family){
        this.name = name;
        this.family = family;
        this.jutsus = new String[5];
    }

    public void train(){
        System.out.println(String.format("Treinamento: ninja %s, da familia %s, dos jutsus %s", name, family, jutsus));
    }
}