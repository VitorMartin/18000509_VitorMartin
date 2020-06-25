package br.maua.classes;

import br.maua.interfaces.Seguranca;

public class Usuario implements Seguranca {

    private final String nome;
    private final String email;
    private final String senha;
    public  final boolean isAdmin;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdmin = autenticarSenha(senha);
    }

    // GETTERS E SETTERS
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", existe='" + isAdmin + '\'' +
                '}';
    }

    @Override
    public boolean autenticarSenha(String senha) {
        String senhaMestre = "123456";
        return senha.equals(senhaMestre);
    }
}
