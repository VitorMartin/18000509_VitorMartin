package Models;

import Funcionario.Funcionario;
import Interfaces.PostarMensagens;

public class HeavyLifter extends Funcionario{

    public HeavyLifter(String nick, String email, String func) {
        super(nick, email, func);
    }

    @Override
    public void msgNormal() {
        System.out.println("Nick: " + this.getNick() + " Podem contar conosco");
    }
    
    @Override
    public void msgExtra(){
        System.out.println("Nick: " + this.getNick() + "N00b_qu3_n_Se_r3pita.bat");
    }
}
