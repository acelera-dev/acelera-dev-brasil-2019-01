package org.acelera.brasil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Carrinho {

    private List<String> produtos = new ArrayList<>();

    private Boolean finalizado;

    private int emitiuNota;

    public List<String> getProdutos() {
        return Optional.ofNullable(produtos)
                .orElse(Collections.emptyList());
    }

    public void adicionar(String produto) {
        this.produtos.add(produto);
    }

    public void remover(String produto) {
        this.produtos.remove(produto);
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "produtos=" + produtos +
                '}';
    }
}
