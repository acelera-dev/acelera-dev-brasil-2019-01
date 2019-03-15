package org.acelera.brasil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar("Caneca");
        carrinho.adicionar("Livro");
        carrinho.adicionar("Caderno");
        carrinho.remover("Caderno");
        System.out.println("Resultado o carrinho: " + carrinho);
        List<String> produtos = carrinho.getProdutos();

        Boolean refencia = null;
        System.out.println("o valor da referencia eh " + refencia);
        System.out.println("Resultado o carrinho: " + carrinho);
    }
}

