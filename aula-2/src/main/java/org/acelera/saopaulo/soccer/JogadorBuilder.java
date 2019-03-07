package org.acelera.saopaulo.soccer;

public class JogadorBuilder {
    private String nome;
    private String cidade;
    private String pais;
    private int gols;
    private Posicao posicao;

    JogadorBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public JogadorBuilder withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public JogadorBuilder withPais(String pais) {
        this.pais = pais;
        return this;
    }

    public JogadorBuilder withGols(int gols) {
        this.gols = gols;
        return this;
    }

    public JogadorBuilder withPosicao(Posicao posicao) {
        this.posicao = posicao;
        return this;
    }

    public Jogador build() {
        return new Jogador(nome, cidade, pais, gols, posicao);
    }
}