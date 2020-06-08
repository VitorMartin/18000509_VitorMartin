package Interfaces;

import Funcionario.Funcionario;

public class HeavyLifter extends Funcionario{

    public HeavyLifter(String nick, String email) {
        super(nick, email);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Podem contar conosco!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "N00b_qu3_n_Se_r3pita.bat"
    }
}

