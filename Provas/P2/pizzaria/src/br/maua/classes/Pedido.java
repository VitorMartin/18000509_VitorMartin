package br.maua.classes;

import br.maua.maps.Estados;

import java.util.Random;

public class Pedido {

    private final String id;
    private final String descricao;
    private final Double valor;
    private final String pagamento;
    private String estado = Estados.map.get(0);

    public Pedido(String descricao, Double valor, String pagamento) {
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
    }

    public String getId() {
        return this.id;
    }

    public void mudarEstado(String novoEstado){
        this.estado = novoEstado;
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
