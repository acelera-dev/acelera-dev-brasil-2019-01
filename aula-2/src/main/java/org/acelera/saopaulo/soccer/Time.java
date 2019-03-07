package org.acelera.saopaulo.soccer;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Time {

    private final String nome;

    private final List<Jogador> jogadores;

    private Time(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }

    public void adicionar(Jogador jogador) {
        jogadores.add(jogador);
    }

    public static Time of(String nome) {
        return new Time(requireNonNull(nome, "nome eh obrigatorio"));
    }

    public int total() {
        return jogadores.size();
    }


    public List<Jogador> getFantastico() {
        return jogadores.stream()
                .filter(j -> j.getGols()>= 3)
                .collect(Collectors.toList());
    }

    public Map<Posicao, List<Jogador>> getJogadorByPosicao() {
        return jogadores.stream()
                .collect(groupingBy(Jogador::getPosicao));
    }

    public Jogador getArtilheiro() {
        Comparator<Jogador> maiorGols = Comparator.comparing(Jogador::getGols);
        Comparator<Jogador> peloNome= Comparator.comparing(Jogador::getNome);
        Optional<Jogador> artilheiro = jogadores.stream()
                .max(maiorGols.thenComparing(peloNome));
        return artilheiro
                .orElseThrow(() -> new IllegalStateException("Sempre deve ter um artilheiro no time"));

    }

    public List<Jogador> getJogadoresOrderByGols() {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getGols).reversed())
                .collect(Collectors.toList());
    }
    
    public boolean removeJogador(String nome) {			
		return jogadores.removeIf(j -> j.getNome().equals(nome));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Time [nome=").append(nome).append(", jogadores=").append(jogadores).append("]");
		return builder.toString();
	}
}
