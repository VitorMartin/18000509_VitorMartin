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
        String str = "";
        for (int i = 0; i < map.size(); i++) {
            str += i + " - " + map.get(i) + "\n";
        }
        return str;
    }

}
