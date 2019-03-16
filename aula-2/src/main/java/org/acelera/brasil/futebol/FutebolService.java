package org.acelera.brasil.futebol;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.acelera.brasil.futebol.exception.TimeNaoEncontradoException;

/**
 * Classe responsável pela manipulação dos dados dos times de futebol e seus
 * jogadores.
 * 
 * @author edmilson.santana
 *
 */
public class FutebolService {

	private static final int QTD_GOLS_EM_UMA_PARTIDA = 3;
	private Collection<Time> times;

	public FutebolService() {
		times = new HashSet<>();
	}

	public void adicionarTime(Time time) {
		if (time != null) {
			this.times.add(time);
		}
	}

	public List<Jogador> buscarJogadoresComDireitoAoGolNoFantastico() {
		return this.getJogadores().filter((jogador) -> jogador.getNumeroDeGols() >= QTD_GOLS_EM_UMA_PARTIDA)
				.collect(Collectors.toList());
	}

	public Jogador buscarArtilheiroTime(String nomeTime) {
		Time timeEncontrado = this.times.stream().filter((time) -> time.getNome().equals(nomeTime)).findFirst()
				.orElseThrow(() -> new TimeNaoEncontradoException());

		return timeEncontrado.getArtilheiro();
	}

	public List<Jogador> buscarJogadoresOrdenadosPorNumeroDeGols() {
		return this.getJogadores().sorted(Comparator.comparing(Jogador::getNumeroDeGols)).collect(Collectors.toList());
	}

	public Map<Posicao, List<Jogador>> agruparJogadoresPorPosicao() {
		return this.getJogadores().collect(Collectors.groupingBy(Jogador::getPosicao));
	}

	public List<String> getNomesDeJogadores(List<Jogador> jogadores) {
		return jogadores.stream().map(Jogador::getNome).collect(Collectors.toList());
	}

	private Stream<Jogador> getJogadores() {
		return times.stream().flatMap((time) -> time.getJogadores().stream());
	}

}
