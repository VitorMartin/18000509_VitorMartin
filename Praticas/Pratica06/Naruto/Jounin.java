package Naruto;

public class Jounin extends RankedNinja{
    public Jounin(String name, String family, String misison) {
        super(name, family, misison);
    }

    @Override
    public void train(){
        System.out.println("Override Jounin.train()");
    }

    // @Override // -------------> NAO PODE DAR OVERRIDE PARA ALGUEM QUE EH FINAL
    // public void gotoMission(){

    // }
}