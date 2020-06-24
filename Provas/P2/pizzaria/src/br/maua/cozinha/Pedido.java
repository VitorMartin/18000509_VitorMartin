package br.maua.cozinha;

import br.maua.enumerates.Pagamento;
import br.maua.maps.Sabores;

import java.util.Random;

public class Pedido implements Sabores {

    private final String id, descricao, estado;
    private final Pagamento pagamento;
    private final Double valor;

    public Pedido(String descricao, Pagamento pagamento) {
        this.id = setId();
        this.descricao = descricao;
        this.valor = Sabores.valores.get(descricao);
        this.pagamento = pagamento;
        this.estado = "estado";
    }

    private String setId(){
        Random random = new Random();
        StringBuilder idGerado = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idGerado.append(random.nextInt(10));
        }
        return idGerado.toString();
    };

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", pagamento='" + pagamento + '\'' +
                ", estado='" + estado + '\'' +
                ", valor=" + valor +
                '}';
    }
}
