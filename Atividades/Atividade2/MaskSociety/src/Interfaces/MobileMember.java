package Interfaces;

import Funcionario.Funcionario;

public class MobileMember extends Funcionario{
    
    public MobileMember(String nick, String email) {
        super(nick, email);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Happy Coding!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "Happy_C0d1ng. Maskers"
    }
}