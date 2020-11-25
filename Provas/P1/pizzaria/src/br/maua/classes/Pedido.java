package br.maua.classes;

import br.maua.maps.Estados;

import java.util.Random;

/**
 * Classe Pedido, onde é guardado as informações de um pedido.
 */

public class Pedido {

    /**
     * Código identificador do pedido.
     * 
     * @see #setId()
     */
    private final String id;
    /**
     * O que o cliente pediu.
     */
    private final String descricao;
    /**
     * Valor do pedido.
     */
    private final Double valor;
    /**
     * Forma de pagamento.
     *
     * @see br.maua.maps.Pagamentos
     */
    private final String pagamento;
    /**
     * Estado do pedido. Quando o Pedido é instanciado, o estado inicial é sempre o mesmo.
     *
     * @see Estados
     */
    private String estado = Estados.map.get(0);

    /**
     * Construtor da classe Pedido. Preenche alguns dos atributos da classe.
     *
     * @param descricao {@link #descricao}
     * @param valor {@link #valor}
     * @param pagamento {@link #pagamento}
     */
    public Pedido(String descricao, Double valor, String pagamento) {
        this.id = setId();
        this.descricao = descricao;
        this.valor = valor;
        this.pagamento = pagamento;
    }

    // SETTERS E GETTERS
    /**
     * Cria o ID do pedido, gerando três algarismos aleatórios.
     *
     * @return Retorna três algarismos aleatórios em forma de String.
     */
    private String setId(){
        Random random = new Random();
        StringBuilder idGerado = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idGerado.append(random.nextInt(10));
        }
        return idGerado.toString();
    }

    /**
     * Getter para o ID do Pedido
     *
     * @return Retorna o ID de um Pedido instanciado.
     * @see #id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter para o estado de um Pedido instanciado.
     *
     * @param novoEstado Novo estado do pedido.
     * @see #estado
     */
    public void mudarEstado(String novoEstado){
        this.estado = novoEstado;
    }

    /**
     * Override to método Object.toString().
     *
     * @return Retorna a instância da classe Pedido em forma de String.
     * @see Pedido
     * @see Object#toString()
     */
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
