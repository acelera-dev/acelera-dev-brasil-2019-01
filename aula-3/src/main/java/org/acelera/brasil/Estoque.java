package org.acelera.brasil;

import java.util.List;

public interface Estoque {

    boolean temProdutos(Produto produto);

    void reduzirProdutos(Produto produto);
}
