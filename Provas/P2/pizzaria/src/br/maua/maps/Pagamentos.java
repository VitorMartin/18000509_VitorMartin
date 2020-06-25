package br.maua.maps;

import java.util.HashMap;
import java.util.Map;

public interface Pagamentos {

    Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "CREDITO");
        put(1, "DEBITO");
        put(2, "DINHEIRO");
        put(3, "VALE_ALIMENTACAO");
        put(4, "VALE_REFEICAO");
    }};

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
