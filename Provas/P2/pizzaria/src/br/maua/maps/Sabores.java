package br.maua.maps;


import java.util.HashMap;
import java.util.Map;

public interface Sabores {

    Map<String, Double> valores = new HashMap<String, Double>() {{
        put("Mucarela", 30.50);
        put("Quatro Queijos", 33.23);
        put("Calabresa", 35.89);
    }};

}
