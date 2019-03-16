package org.acelera.brasil.futebol;

import java.util.function.Supplier;

/**
 * {@link Enum} responsável pela representação da posição em campo de um jogador de futebol.
 * 
 * @author edmilson.santana
 *
 */
public enum Posicao implements Supplier<String> {

	GOLEIRO("Goleiro"), DEFESA("Defesa"), ATAQUE("Ataque");
	
	private final String descricao;
	
	private Posicao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String get() {
		return this.descricao;
	}
}
