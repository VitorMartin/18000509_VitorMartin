public class Player{
    public Player(String name, String choice){
        this.name = name;
        this.choice = choice;
    }

    private String name, choice;
    
    
    public void playerInfo(){
        System.out.println("Nome:    " + this.name);
        System.out.println("Escolha: " + this.choice);
    }
    public String getName(){
        return this.name;
    }
    public String getChoice(){
        return this.choice;
    }
}