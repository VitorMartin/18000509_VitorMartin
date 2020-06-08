package Models;

import Funcionario.Funcionario;

public class MobileMember extends Funcionario{
    
    public MobileMember(String nick, String email, String func) {
        super(nick, email, func);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Happy Coding!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "Happy_C0d1ng. Maskers"
    }
}