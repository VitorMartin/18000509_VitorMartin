package Models;

import Funcionario.Funcionario;
import Interfaces.PostarMensagens;

public class ScriptGuy extends Funcionario{

    public ScriptGuy(String nick, String email, String func) {
        super(nick, email, func);
    }

    @Override
    public void msgNormal() {
        System.out.println("Nick: " + this.getNick() + "Prazer em ajudar novos amigos de código!");
    }
    
    @Override
    public void msgExtra(){
        System.out.println("Nick: " + this.getNick() + "QU3Ro_S3us_r3curs0s.py");
    }
}
