package org.acelera.brasil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CarrinhoTest {


    @Mock
    private Estoque estoque;

    @Mock
    private Pagamento pagamento;

    @InjectMocks
    private Carrinho carrinho;

    @Test
    @DisplayName("Deve realizar o caminho perfeito para uma compra")
    public void deveComprar() {
        Produto produto = new Produto("Banana");
        Mockito.when(estoque.temProdutos(produto)).thenReturn(true);
        carrinho.adicionar(produto);
        carrinho.comprar();
        assertTrue(carrinho.estaVazio());
        Mockito.verify(pagamento).pagar(produto);
        Mockito.verify(estoque).reduzirProdutos(produto);
    }

    @Test
    @DisplayName("Nao deve comprar quando o estoque estiver vazio")
    public void naoDeveComprarEstoqueVazio(){
        Produto produto = new Produto("Banana");
        Mockito.when(estoque.temProdutos(produto)).thenReturn(false);
        carrinho.adicionar(produto);
        carrinho.comprar();
        assertTrue(carrinho.estaVazio());
        Mockito.verify(pagamento, Mockito.never()).pagar(produto);
        Mockito.verify(estoque, Mockito.never()).reduzirProdutos(produto);
    }


    @Test
    @DisplayName("Nao deve esvaziar o estoque quando tiver erro no pagamento")
    public void naoDeveTerPorqueNaoPagou() {
        Produto produto = new Produto("Banana");
        Mockito.when(estoque.temProdutos(produto)).thenReturn(true);
        Mockito.when(pagamento.pagar(produto))
                .thenThrow(new PagamentoException("houve um error no pagamento"));
        carrinho.adicionar(produto);

        PagamentoException pagamentoException = assertThrows(PagamentoException.class, carrinho::comprar);
        Mockito.verify(estoque, Mockito.never()).reduzirProdutos(produto);

    }

  }