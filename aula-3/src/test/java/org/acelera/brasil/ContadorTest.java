package org.acelera.brasil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContadorTest {

    private Contador contador;

    @BeforeEach
    public void setUp() {
        contador = new Contador();
    }

    @Test
    @DisplayName("Deve adicionar um produto no contador \uD83D\uDE31")
    public void deveAdicionarProduto() {
        contador.add("banana");
        Assertions.assertEquals(1, contador.quantidade("banana"));
    }

    @Test
    @DisplayName("Deve retornar erro quando o produto for nulo")
    public void deveRetornarErro() {
        Assertions.assertThrows(NullPointerException.class, () -> contador.add(null));

    }

    @Test
    @DisplayName("Deve retornar zero quando o contador estiver vazio")
    public void deveRetornarZeroQuandoEstoqueEstiverVazio() {
    Assertions.assertEquals(0, contador.quantidade("banana"));
    }

}