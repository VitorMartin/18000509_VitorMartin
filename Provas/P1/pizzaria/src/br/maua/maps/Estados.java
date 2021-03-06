package br.maua.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap dos estados possíveis de um pedido.
 * <p>
 * Por hora, funciona igual um ArrayList, porém está implementado como
 * HashMap, pois ele dá mais flexibilidade, caso queira alterar a chave para qualquer outro objeto.
 * <p>
 * Key   : Integer
 * <p>
 * Value : String
 */

public interface Estados {

    /**
     * HashMap dos estados possíveis de um pedido.
     */
    Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "REALIZADO");
        put(1, "PREPARACAO");
        put(2, "SAIU_PARA_ENTREGA");
        put(3, "ENTREGUE");
        put(4, "DEVOLVIDO");
    }};

    /**
     * Semelhante ao método Object.toString(), que retorna a instância de um Objeto em forma de String.
     *
     * @return Retorna o HashMap, com todos os seus elementos e em forma de String.
     */
    static String mapToString() {
        // Template de como a String deve ficar:
        /*
        0 - REALIZADO
        1 - PREPARACAO
        2 - SAIU_PARA_ENTREGA
         */
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < map.size() - 1; i++) {
            str.append(i).append(" - ").append(map.get(i)).append("\n");
        }
        str.append(map.size() - 1).append(" - ").append(map.get(map.size() - 1));
        return str.toString();
    }
}