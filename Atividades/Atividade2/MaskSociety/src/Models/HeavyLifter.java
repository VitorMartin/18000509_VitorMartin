package Models;

import Funcionario.Funcionario;

public class HeavyLifter extends Funcionario{

    public HeavyLifter(String nick, String email, String func) {
        super(nick, email, func);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Podem contar conosco!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "N00b_qu3_n_Se_r3pita.bat"
    }
}

