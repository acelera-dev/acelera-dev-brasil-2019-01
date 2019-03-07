package org.acelera.saopaulo;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private Map<String, Integer> controle = new HashMap<>();

    public void adicionar(String produto, int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Para adicionar so positivo");
        }
        controle.put(produto, quantidade);
    }

    public void remover(String produto, int quantidade) {

        if (quantidade < 0) {
            throw new IllegalArgumentException("O valor nao pode ser negativo");
        }
        Integer quantidadeEstoque = controle.getOrDefault(produto, 0);
        if(quantidade > quantidadeEstoque) {
            throw new IllegalArgumentException("");
        }

        int novaQuantidade = quantidadeEstoque - quantidade;
        controle.put(produto, novaQuantidade);

    }
}
