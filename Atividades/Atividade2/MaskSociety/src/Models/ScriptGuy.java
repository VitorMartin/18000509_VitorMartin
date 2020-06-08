package Models;

import Funcionario.Funcionario;

public class ScriptGuy extends Funcionario{

    public ScriptGuy(String nick, String email, String func) {
        super(nick, email, func);
    }

    public void mensagemNormal(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem NORMAL"); // "Prazer em ajudar novos amigos de código!"
    }

    public void mensagemExtra(){
        System.out.println("Nick: " + this.getNick() + "  ==>  mensagem EXTRA"); // "QU3Ro_S3us_r3curs0s.py"
    }
    
}