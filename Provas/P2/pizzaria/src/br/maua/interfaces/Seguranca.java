package br.maua.interfaces;

public interface Seguranca {

    String senhaMestre = "123456";

    static Boolean autenticarSenha(String senha){
        return senha.equals(senhaMestre);
    }

}
