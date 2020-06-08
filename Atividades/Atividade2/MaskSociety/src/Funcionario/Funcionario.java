package Funcionario;

import Interfaces.Apresentacoes;
import Interfaces.PostarMensagens;

public class Funcionario implements PostarMensagens, Apresentacoes{
    public Funcionario(String nick, String email, String funcao) {
        this.nick = nick;
        this.email = email;
        this.funcao = funcao;
    }

    private String nick, email, funcao;

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void show() {
        System.out.println("Nome: " + nick + "\tEmail: " + email + "\tFuncao: " + funcao);
    }

    @Override
    public void msgExtra() {}

    @Override
    public void msgNormal() {}
}