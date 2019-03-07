package org.acelera.saopaulo.soccer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JogadorTest {

    private Jogador jogador;

    @BeforeEach
    public void setUp() {
        System.out.println("antes de executar o metodo");
        jogador = Jogador.builder().withNome("Neymar")
                .withCidade("Salvador")
                .withPais("Brasil").withGols(10)
                .withPosicao(Posicao.ATAQUE).build();
    }

    @AfterEach
    public void depois(){
        System.out.println("depois de executar o metodo");
        jogador.fezGol();
    }

    @Test
    @DisplayName("deve criar uma instancia de jogador")
    public void deveCriarInstancia() {
        Jogador neymar = Jogador.builder().withNome("Neymar")
                .withCidade("Salvador")
                .withPais("Brasil").withGols(10)
                .withPosicao(Posicao.ATAQUE).build();
        assertNotNull(neymar);
    }

    @Test
    @DisplayName("Dado um jogador que fez 10 gols, no gol deve aparecer 11")
    public void deveFazerGol() {
        assertEquals(10, jogador.getGols());
        jogador.fezGol();
        assertEquals(11, jogador.getGols());
    }

    @Test
    public void fazNada() {
        assertEquals(10, jogador.getGols());
    }
}