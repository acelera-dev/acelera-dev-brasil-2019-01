package org.acelera.saopaulo.soccer;

public class Jogador {

    private final String nome;

    private final String cidade;

    private final String pais;

    private final Posicao posicao;

    private int gols;


    Jogador(String nome, String cidade, String pais, int gols, Posicao posicao) {
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
        this.gols = gols;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public int getGols() {
        return gols;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void fezGol() {
        gols++;
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }
}
