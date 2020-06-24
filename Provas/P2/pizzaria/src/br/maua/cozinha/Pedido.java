package br.maua.cozinha;

import br.maua.enumerates.Estado;
import br.maua.enumerates.Pagamento;

import java.util.Random;

public class Pedido {

    private final String id;
    private String descricao;
    private Double valor;
    private Pagamento pagamento;
    private Estado estado = Estado.REALIZADO;

    public Pedido(String descricao, Double valor, Pagamento pagamento) {
        this.id = setId();
        this.descricao = descricao;
        this.valor = valor;
        this.pagamento = pagamento;
    }

    private String setId(){
        Random random = new Random();
        StringBuilder idGerado = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idGerado.append(random.nextInt(10));
        }
        return idGerado.toString();
    };

    public String getId() {
        return this.id;
    }

    public boolean mudarEstado(Estado novoEstado){
        this.estado = novoEstado;
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor='" + valor + '\'' +
                ", pagamento='" + pagamento + '\'' +
                ", estado='" + estado + '\''
                 +
                '}';
    }

}
