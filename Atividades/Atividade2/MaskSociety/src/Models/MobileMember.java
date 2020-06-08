package Models;

import Funcionario.Funcionario;
import Interfaces.PostarMensagens;

public class MobileMember extends Funcionario{

    public MobileMember(String nick, String email, String func) {
        super(nick, email, func);
    }

    @Override
    public void msgNormal() {
        System.out.println("Nick: " + this.getNick() + "Happy Coding!");
    }
    
    @Override
    public void msgExtra(){
        System.out.println("Nick: " + this.getNick() + "Happy_C0d1ng. Maskers");
    }
}
