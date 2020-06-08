package Funcionario;

public class Funcionario {
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

    public void show() {
        System.out.println("Nome: " + nick + "\tEmail: " + email + "\tFuncao: " + funcao);
    }
}