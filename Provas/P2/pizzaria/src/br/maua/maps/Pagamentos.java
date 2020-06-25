package br.maua.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap das formas de pagamento possíveis de um pedido.
 *
 * Por hora, funciona igual um ArrayList, porém está implementado como
 * HashMap, pois ele dá mais flexibilidade, caso queira alterar a chave para qualquer outro objeto.
 *
 * Key   : Integer
 * Value : String
 */

public interface Pagamentos {

    /**
     * HashMap das formas de pagamento possíveis de um pedido.
     */
    Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "CREDITO");
        put(1, "DEBITO");
        put(2, "DINHEIRO");
        put(3, "VALE_ALIMENTACAO");
        put(4, "VALE_REFEICAO");
    }};

    /**
     * Semelhante ao método Object.toString(), que retorna a instância de um Objeto em forma de String.
     *
     * @return Retorna o HashMap, com todos os seus elementos e em forma de String.
     * @see Object#toString()
     */
    static String mapToString() {
        // Template de como a String deve ficar:
        /*
        0 - CREDITO
        1 - DEBITO
        2 - DINHEIRO
         */
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < map.size() - 1; i++) {
            str.append(i).append(" - ").append(map.get(i)).append("\n");
        }
        str.append(map.size() - 1).append(" - ").append(map.get(map.size() - 1));
        return str.toString();
    }

}
