package org.acelera.brasil.futebol;

/**
 * Classe responsável pela representação de um jogador de futebol.
 * 
 * @author edmilson.santana
 *
 */
public class Jogador {

	private final String nome;

	private final String cidade;

	private final String pais;

	private final Posicao posicao;

	private final Integer numeroDeGols;

	protected Jogador(String nome, String cidade, String pais, Posicao posicao, Integer numeroDeGols) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.pais = pais;
		this.posicao = posicao;
		this.numeroDeGols = numeroDeGols;
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

	public Posicao getPosicao() {
		return posicao;
	}

	public Integer getNumeroDeGols() {
		return numeroDeGols;
	}

	public static JogadorBuilder builder() {
		return new JogadorBuilder();
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", cidade=" + cidade + ", pais=" + pais + ", posicao=" + posicao
				+ ", numeroDeGols=" + numeroDeGols + "]";
	}

}
