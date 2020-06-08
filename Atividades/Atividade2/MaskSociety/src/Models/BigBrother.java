package Models;

import Funcionario.Funcionario;

public class BigBrother extends Funcionario{

    public BigBrother(String nick, String email, String func) {
        super(nick, email, func);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Sempre ajudando as pessoas membros ou não S2!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "..."
    }
}