package org.acelera.brasil.futebol;

import java.util.Objects;

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

	private Jogador(Builder builder) {
		this.nome = builder.nome;
		this.cidade = builder.cidade;
		this.pais = builder.pais;
		this.posicao = builder.posicao;
		this.gols = builder.gols;
	}

	public static final class Builder {

		private  String nome;

		private  String cidade;

		private  String pais;

		private  Posicao posicao;

		private  Integer gols;

		public Builder() {}

		public Builder withNome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder withCidade(String cidade) {
			this.cidade = cidade;
			return this;
		}

		public Builder withPais(String pais) {
			this.pais = pais;
			return this;
		}

		public Builder withPosicao(Posicao posicao) {
			this.posicao = posicao;
			return this;
		}

		public Builder withGols(Integer gols) {
			this.gols = gols;
			return this;
		}

		public Jogador build() {
			Objects.requireNonNull(this.nome, "o nome é obrigatorio");
			Objects.requireNonNull(this.cidade, "o cidade é obrigatorio");
			Objects.requireNonNull(this.pais, "o pais é obrigatorio");
			Objects.requireNonNull(this.posicao, "a posição é obrigatorio");
			Objects.requireNonNull(this.gols, "numero de gols é obrigatorio");

			if (this.gols < 0) {
				throw new IllegalArgumentException("O número de gols não pode ser negativo.");
			}

			return new Jogador(this);
		}
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

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", cidade=" + cidade + ", pais=" + pais + ", posicao=" + posicao
				+ ", gols=" + gols + "]";
	}

}

