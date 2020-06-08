package Funcionario;

public class Funcionario {
    public Funcionario(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    private String nick, email, funcao;

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }
}