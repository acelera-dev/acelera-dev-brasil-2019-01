package org.acelera.brasil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Contador {

    private Map<String, Integer> controle = new HashMap<>();

    public void add(String produto) {
        Objects.requireNonNull(produto, "produto eh obrigatorio");

        controle.computeIfPresent(produto, (k, v) -> v + 1);
        controle.put(produto, 1);
    }

    public int quantidade(String produto) {
        Objects.requireNonNull(produto, "produto eh obrigatorio");
        return controle.getOrDefault(produto, 0);
    }
}
