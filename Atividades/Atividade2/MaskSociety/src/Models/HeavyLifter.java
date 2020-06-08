package Models;

import Funcionario.Funcionario;
import Interfaces.PostarMensagens;

public class HeavyLifter extends Funcionario{

    public HeavyLifter(String nick, String email, String func) {
        super(nick, email, func);
    }

    @Override
    public void msgNormal() {
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL");
    }
    
    @Override
    public void msgExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA");
    }
}