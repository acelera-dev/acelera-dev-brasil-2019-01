package org.acelera.saopaulo.soccer;

import static org.acelera.saopaulo.soccer.Posicao.ATAQUE;
import static org.acelera.saopaulo.soccer.Posicao.DEFESA;
import static org.acelera.saopaulo.soccer.Posicao.GOLEIRO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class TimeTest {

    private final Time bahia = Time.of("Bahia");

    @BeforeEach
    void setUp() {
        Jogador bobo = mock("Bobo", 3, DEFESA);
        Jogador lima = mock("Lima", 5);
        Jogador neymar = mock("Neymar", 1);

        bahia.adicionar(bobo);
        bahia.adicionar(lima);
        bahia.adicionar(neymar);
    }

    @Test
    @DisplayName("Deve criar uma nova instancia de time")
    void deveCriarTime() {
        assertAll(
            () -> assertNotNull(bahia),
            () -> assertNotSame(bahia, Time.of("Bahia"))
        );

    }

    @Test
    @DisplayName("Deve falhar ao tentar criar uma instancia de time sem informar o nome")
    void deveFalharCriarTime() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> Time.of(null));
        assertEquals(exception.getMessage(), "nome eh obrigatorio");
    }

    @Test
    @DisplayName("Deve adicionar jogador ao time")
    void deveAdicionarJogador() {

        Time bahia = Time.of("Bahia");
        Jogador mock = Mockito.mock(Jogador.class);
        Mockito.when(mock.getNome()).thenReturn("ahha pegadinho do Malandro");

        bahia.adicionar(mock);

        Jogador jogador = bahia.getJogadores().get(0);
        assertAll(
                () -> assertThat(bahia.total(), equalTo(1)),
                () -> assertTrue(bahia.getJogadores().contains(mock)),
                () -> assertSame(mock, jogador)
        );
    }

    @Test
    @DisplayName("Deve falhar ao remover jogadores do time")
    void deveFalharExclusaoJogadores() {

        List<Jogador> jogadores = bahia.getJogadores();

        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, jogadores::clear);
        assertThat(exception.getMessage(), isEmptyOrNullString());
    }

    @Test
    @DisplayName("Deve listar os jogadores com direito ao gol no fantástico")
    void deveRetornarFantastico() {

        List<Jogador> fantastico = bahia.getFantastico();
        assertAll(
                () -> assertThat(fantastico, hasSize(2)),
                () -> assertThat(fantastico, containsInAnyOrder(matchByNome("Bobo", "Lima")))
        );

    }

    @Test
    @DisplayName("Deve agrupar os jogadores pela posição")
    void deveAgruparPorPosicao() {

        Jogador jorge = mock("Jorge", 3, DEFESA);
        Jogador jose = mock("jose", 3, DEFESA);
        Jogador taffarel = mock("Taffarel", 0, GOLEIRO);

        bahia.adicionar(jorge);
        bahia.adicionar(jose);
        bahia.adicionar(taffarel);

        Map<Posicao, List<Jogador>> jogaboresByPosicao = bahia.getJogadorByPosicao();

        matchByPosicao(jogaboresByPosicao, GOLEIRO, 1, "Taffarel");
        matchByPosicao(jogaboresByPosicao, DEFESA, 3, "Bobo", "Jorge", "jose");
        matchByPosicao(jogaboresByPosicao, ATAQUE, 2, "Lima", "Neymar");
    }

    @Test
    @DisplayName("Deve retornar o artilheiro do time")
    void deveRetornarOArtilheiro() {
        Jogador artilheiro = bahia.getArtilheiro();
        assertAll(
                () -> assertEquals(artilheiro.getNome(), "Lima"),
                () ->assertEquals(artilheiro.getGols(), 5)
        );
    }

    @Test
    @DisplayName("Deve falhar ao retornar o artilheiro do time")
    void deveFalharRetornarOArtilheiro() {

        Time bahia = Time.of("Bahia");

        Exception exception = assertThrows(IllegalStateException.class, bahia::getArtilheiro);
        assertAll(
                () -> assertThat(exception, is(notNullValue())),
                () -> assertThat(exception.getMessage(), is("Sempre deve ter um artilheiro no time"))
        );
    }


    @Test
    @DisplayName("Deve ordenar os jogadores pelo número de gols")
    void deveRetornarOrdenadoPorGols() {

        List<Jogador> jogadores = bahia.getJogadoresOrderByGols();
        assertThat(jogadores, contains(matchByNome("Lima", "Bobo", "Neymar")));
    }
    
    @Test
    @DisplayName("Remove jogador pelo nome")
    void removeJogador() {
    	boolean esperado = true;
        assertEquals(esperado, bahia.removeJogador("Bobo"));
    }
    

    private Jogador mock(String nome, int gols) {
        return mock(nome, gols, ATAQUE);
    }

    private Jogador mock(String nome, int gols, Posicao posicao) {

        Jogador jogador = Mockito.mock(Jogador.class);

        Mockito.when(jogador.getNome()).thenReturn(nome);
        Mockito.when(jogador.getGols()).thenReturn(gols);
        Mockito.when(jogador.getPosicao()).thenReturn(posicao);

        return jogador;
    }

    private void matchByPosicao(final Map<Posicao, List<Jogador>> jogaboresByPosicao, final Posicao posicao, final int quantidadeJogadores, final String... nomes) {

        List<Jogador> jogadores = jogaboresByPosicao.get(posicao);
        assertAll(
                () -> assertThat(jogaboresByPosicao, hasKey(is(posicao))),
                () -> assertThat(jogaboresByPosicao, hasEntry(is(posicao), is(jogadores))),
                () -> assertThat(jogadores, hasSize(quantidadeJogadores)),
                () -> assertThat(jogadores, containsInAnyOrder(matchByNome(nomes)))
        );
    }

    private List<Matcher<Object>> matchByNome(final String... nomes) {

        return Arrays
                .stream(nomes)
                .map(name -> hasProperty("nome", is(name)))
                .collect(Collectors.toList());
    }

}