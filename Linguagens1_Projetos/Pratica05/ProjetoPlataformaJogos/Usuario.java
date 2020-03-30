public class Usuario {
    private String nick, senha, email;

    public Usuario(String nick, String senha, String email) {
        this.nick = nick;
        this.senha = senha;
        this.email = email;
    }

    public boolean verificarSenha(String senha){
        return this.senha.equals(senha);
    }

    public String getNick() {
        return nick;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}