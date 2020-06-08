package Interfaces;

import Funcionario.Funcionario;

public class ScriptGuys extends Funcionario{

    public ScriptGuys(String nick, String email) {
        super(nick, email);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Prazer em ajudar novos amigos de código!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "QU3Ro_S3us_r3curs0s.py"
    }
    
}