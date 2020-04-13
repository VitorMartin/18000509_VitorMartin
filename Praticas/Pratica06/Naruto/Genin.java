package Naruto;

public class Genin extends RankedNinja{
    public Genin(String name, String family, String misison) {
        super(name, family, misison);
    }

    public void mudarMissao(){
        mission = "Genin mudou missao";
    }
}