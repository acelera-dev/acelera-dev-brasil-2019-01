package org.acelera.brasil.futebol;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.acelera.brasil.futebol.exception.TimeNaoPossuiJogadoresException;

/**
 * Classe responsável pela representação de um time de futebol.
 * 
 * @author edmilson.santana
 *
 */
public class Time {

	private final String nome;

	private Collection<Jogador> jogadores;

	public Time(String nome) {
		this.nome = nome;
		this.jogadores = new HashSet<>();
	}
	
	public String getNome() {
		return nome;
	}

	public Jogador getArtilheiro() {
		return this.jogadores.stream().max(Comparator.comparing(Jogador::getNumeroDeGols))
				.orElseThrow(() -> new TimeNaoPossuiJogadoresException());
	}
	
	public List<String> getNomeJogadores() {
		return this.jogadores.stream().map(Jogador::getNome).collect(Collectors.toList());
	}

	public Collection<Jogador> getJogadores() {
		return Collections.unmodifiableCollection(this.jogadores);
	}

	public void adicionarJogador(Jogador jogador) {
		if (jogador != null) {
			this.jogadores.add(jogador);
		}
	}

	@Override
	public String toString() {
		return "Time [nome=" + nome + "]";
	}
	
}
