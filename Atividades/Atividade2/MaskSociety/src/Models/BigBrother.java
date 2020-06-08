package Interfaces;

import Funcionario.Funcionario;

public class BigBrother extends Funcionario{

    public BigBrother(String nick, String email) {
        super(nick, email);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Sempre ajudando as pessoas membros ou não S2!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "..."
    }
}