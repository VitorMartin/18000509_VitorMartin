package Naruto;

public class RankedNinja extends Ninja{
    protected String mission;

    public RankedNinja(String name, String family, String mission){
        super(name, family);
        this.mission = mission;
    }

    @Override
    public void train(){
        System.out.println("Override rankedNinja.train()");
    }

    public final void gotoMission(){
        System.out.println("Indo para missao: " + this.mission);
    }
}
