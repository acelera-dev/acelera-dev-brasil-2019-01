package org.acelera.brasil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Contador {

    private Map<String, Integer> controle = new HashMap<>();

    public void add(String produto) {
        Objects.requireNonNull(produto, "produto eh obrigatorio");

        controle.computeIfPresent(produto, (k, v) -> v + 1);
        controle.computeIfAbsent(produto, k -> 1);
    }

    public int quantidade(String produto) {
        return controle.getOrDefault(produto, 0);
    }
}
