// Vitor Martin Simoni - 18.00050-9

public class Usuario {
    private String nome, email, senha;

    public Usuario (String nome, String email, String senha){
        this.nome  = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean senhaCorreta(String tentativa){
        return tentativa.equals(this.senha);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }    

    public String getInfo(){
        return String.format("nome: %s , \t email : %s , \t senha : %s", this.nome, this.email, this.senha);
    }
}