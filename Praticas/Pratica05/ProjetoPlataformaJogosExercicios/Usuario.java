public class Usuario {
    private String nick, email, senha;

    public Usuario(String nick, String email, String senha) {
        this.nick = nick;
        this.email = email;
        this.senha = senha;
    }

    public boolean verificarSenha(String senha){
        return this.senha.equals(senha);
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public String getInfo() {
        return String.format("{nick:\"%s\",email:\"%s\",senha:\"%s\"}", this.nick, this.email, this.senha);
    }
}