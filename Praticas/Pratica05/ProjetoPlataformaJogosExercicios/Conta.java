import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Conta {
    private Usuario usuario;
    private ArrayList<Jogo> jogos;
    private double creditos;

    public static final String CAMINHO_CONTA = "./db/conta.csv";
    public static final String CAMINHO_JOGOS = "./db/jogos.csv";

    public Conta(Usuario usuario) {
        this.usuario = usuario;
        this.creditos = 0;
        this.jogos = new ArrayList<>();

        String row = "";
        String nome, genero, descricao;
        
        try {
            BufferedReader fr = new BufferedReader(new FileReader(CAMINHO_CONTA));
            
            row = fr.readLine(); // usuario;xxxx

            if(row == null){
                this.save();
            }

            else{
                System.out.println("Recuperando informacoes da conta do usuario.");

                row = fr.readLine(); // creditos;xxxx
                this.creditos = Double.parseDouble(row.substring(row.indexOf(";") + 1).replace(",", "."));

                row = fr.readLine(); // jogos
                row = fr.readLine(); // null OU nome;xxxx

                while(true){
                    if(row == null){
                        break;
                    }

                    for(int i=0; i<3; i++){
                        nome      = row.substring(row.indexOf(";") + 1);
                        row       = fr.readLine(); // genero;xxxx
                        genero    = row.substring(row.indexOf(";") + 1);
                        row       = fr.readLine(); // descricao;xxxx
                        descricao = row.substring(row.indexOf(";") + 1);
                        row = fr.readLine(); // null OU PROXIMO nome;xxxx

                        this.addJogo(new Jogo(nome, genero, descricao));
                    }
                }
            }
            fr.close();
        }
        catch (Exception e) {
            // System.out.println("Exception ao criar conta:");
            // System.out.println(e);
        }
    }

    public boolean addJogo(Jogo jogo){
        jogos.add(jogo);
        this.save();
        
        return true;
    }

    public boolean addCreditos(double valor){
        this.creditos += valor;
        this.save();
        return true;
    }

    public ArrayList<Jogo> getJogos(){
        return jogos;
    }
    
    public double getCreditos() {
        return creditos;
    }

    public void save(){
        try{
            FileWriter fw = new FileWriter(CAMINHO_CONTA);
            fw.write(this.getInfoAsCSV());
            fw.close();

            FileWriter fw2 = new FileWriter(CAMINHO_JOGOS);
            fw2.write(this.getJogosAsCSV());
        }

        catch (Exception e){
            System.out.println(e);
        }

        try{
            FileWriter fw = new FileWriter(CAMINHO_JOGOS);
            fw.write(this.getJogosAsCSV());
            fw.close();
        }

        catch (Exception e){
            System.out.println(e);
        }
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
  
    public String getInfoAsCSV() {
        String resposta = "";
        resposta = String.format("usuario;%s\ncreditos;%f\njogos\n", this.usuario.getNick(), this.creditos);
        for (Jogo jogo : jogos) {
            resposta += jogo.getInfoAsCSV();
        }
        return resposta;
    }

    public String getJogosAsCSV(){
        String resposta = "";
        for (Jogo jogo : jogos) {
            resposta += jogo.getInfoAsCSV();
        }
        return resposta;
    }
}