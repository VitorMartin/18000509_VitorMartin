import java.io.FileWriter;

public class Usuario {
    private String nick, email, senha;

    public Usuario(String nick, String email, String senha) {
        this.nick = nick;
        this.email = email;
        this.senha = senha;
        try {
            FileWriter fw = new FileWriter("./db/usuario.csv");
            fw.write(String.format("nick;%s\nemail;%s\nsenha;%s", nick, email, senha));
            fw.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean loginCorreto(String tentativaNick, String tentativaSenha){
        return this.nick.equals(tentativaNick) && this.senha.equals(tentativaSenha);
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