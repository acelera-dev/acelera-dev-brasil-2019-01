package org.acelera.brasil.futebol;

/**
 * Classe responsável pela construção de um {@link Jogador}
 * 
 * @author edmilson.santana
 *
 */
public class JogadorBuilder {

	private String nome;

	private String cidade;

	private String pais;

	private Posicao posicao;

	private Integer numeroDeGols;

	protected JogadorBuilder() {}
	
	public JogadorBuilder withNome(String nome) {
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

	public JogadorBuilder withPosicao(Posicao posicao) {
		this.posicao = posicao;
		return this;
	}

	public JogadorBuilder withNumeroDeGols(Integer numeroDeGols) {
		this.numeroDeGols = numeroDeGols;
		return this;
	}

	public Jogador build() {
		return new Jogador(nome, cidade, pais, posicao, numeroDeGols);
	}
}
