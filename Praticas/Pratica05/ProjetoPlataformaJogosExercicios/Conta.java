import java.util.ArrayList;

public class Conta {
    private Usuario usuario;
    private ArrayList<Jogo> jogos;
    private double creditos;

    public Conta(Usuario usuario) {
        this.usuario = usuario;
        this.creditos = 0;
        jogos = new ArrayList<>();
    }

    public boolean addJogo(Jogo jogo){
        jogos.add(jogo);
        return true;
    }

    public boolean addCreditos(double valor){
        this.creditos += valor;
        return true;
    }

    public ArrayList<Jogo> getJogos(){
        return jogos;
    }
    
    public double getCreditos() {
        return creditos;
    }

    public String getInfo(){
        String resposta = "";
        resposta = String.format("{usuario:\"%s\",creditos:\"%f\",jogos:[", this.usuario.getNick(), this.creditos);
        for (Jogo jogo : jogos) {
            resposta += jogo.getInfo() + ",";
        }
        resposta += "]}";
        return resposta;
    }
}