package Naruto;

public class RankedNinja extends Ninja{
    protected String mission;

    public RankedNinja(String name, String family, String mission){
        super(name, family);
        this.mission = mission;
        System.out.println("mission = " + mission);
    }

    public void gotoMission(){
        System.out.println("Indo para missao: " + this.mission);
    }
}
