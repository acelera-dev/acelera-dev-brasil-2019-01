package org.acelera.brasil;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Estoque estoque;

    private Pagamento pagamento;

    private Produto produto;

    public Carrinho(Estoque estoque, Pagamento pagamento) {
        this.estoque = estoque;
        this.pagamento = pagamento;
    }

    public void adicionar(Produto produto) {
        this.produto = produto;
    }

    public void comprar() {
        if (estoque.temProdutos(produto)) {
            pagamento.pagar(produto);
            estoque.reduzirProdutos(produto);
            produto = null;
        } else {
            produto = null;
        }
    }


    public boolean estaVazio() {
        return produto == null;
    }
}
