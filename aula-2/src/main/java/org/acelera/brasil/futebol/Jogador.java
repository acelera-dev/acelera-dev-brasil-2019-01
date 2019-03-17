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

	private final Integer gols;

	Jogador(String nome, String cidade, String pais, Posicao posicao, Integer gols) {
		this.nome = nome;
		this.cidade = cidade;
		this.pais = pais;
		this.posicao = posicao;
		if(gols < 0) {
			throw new IllegalArgumentException("O número de gols não pode ser negativo.");
		}
		this.gols = gols;
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

	public Integer getGols() {
		return gols;
	}

	public static JogadorBuilder builder() {
		return new JogadorBuilder();
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", cidade=" + cidade + ", pais=" + pais + ", posicao=" + posicao
				+ ", gols=" + gols + "]";
	}

}
