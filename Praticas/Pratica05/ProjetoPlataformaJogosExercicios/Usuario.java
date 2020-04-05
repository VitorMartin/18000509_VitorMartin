import java.io.FileWriter;

public class Usuario {
    private String nick, email, senha;

    public static final String CAMINHO_USR = "./db/usuario.csv";
    public static final String CAMINHO_JOGO = "./db/jogos.csv";

    public Usuario(String nick, String email, String senha) {
        this.nick = nick;
        this.email = email;
        this.senha = senha;

        this.save();
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

        this.save();
    }

    public boolean save(){
        try {
            FileWriter fw = new FileWriter(CAMINHO_USR);
            fw.write(this.getInfoAsCSV());
            fw.close();
            
            return true;
        } 

        catch (Exception e) {
            System.out.println(e);

            return false;
        }
    }

    public String getInfo() {
        return String.format("{nick:\"%s\",email:\"%s\",senha:\"%s\"}", this.nick, this.email, this.senha);
    }

    public String getInfoAsCSV(){
        return String.format("nick;%s\nemail;%s\nsenha;%s", nick, email, senha);
    }
}