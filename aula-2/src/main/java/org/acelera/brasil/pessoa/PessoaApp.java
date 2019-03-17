package org.acelera.brasil.pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PessoaApp {

    public static void main(String[] args) {


        Pessoa ada = Pessoa.builder()
                .withNome("Ada")
                .withCidade("Salvador")
                .withPais("Pais")
                .withRg("rg")
                .withCpf("cpf")
                .withEmail("meu-email")
                .build();

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(ada);
        pessoas.add(ada);
        pessoas.add(ada);
        pessoas.add(ada);


        Predicate<Pessoa> fromSalvador = p -> "Salvador".equals(p.getCidade());
        Predicate<Pessoa> nomeComecaComA = p -> p.getNome().startsWith("A");
        Predicate<Pessoa> naoDeSalvador = fromSalvador.negate();

        Predicate<Pessoa> deSalvadorEnomeComecaComA = fromSalvador.and(nomeComecaComA);
        Predicate<Pessoa> deSalvadorOunomeComecaComA = fromSalvador.or(nomeComecaComA);


        List<Pessoa> salvador = pessoas.stream()
                .filter(fromSalvador)
                .collect(Collectors.toList());

        Set<Pessoa> nomesA = pessoas.stream()
                .filter(nomeComecaComA)
                .collect(Collectors.toSet());

        Queue<Pessoa> fila = pessoas.stream()
                .filter(deSalvadorEnomeComecaComA)
                .collect(Collectors.toCollection(LinkedList::new));

        String nomes = pessoas.stream()
                .map(p -> p.getNome())
                .collect(Collectors.joining(","));

        Optional<Integer> reduce = pessoas.stream()
                .map(Pessoa::getIdade)
                .reduce(Integer::sum);

        IntSummaryStatistics statistics = pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .summaryStatistics();

        System.out.println(" " + statistics.getAverage());
        System.out.println(" " + statistics.getCount());
        System.out.println(" " + statistics.getMax());
        System.out.println(" " + statistics.getMin());
        System.out.println(" " + statistics.getSum());


        Map<String, List<Pessoa>> pessoasAgrupadasPorCidade =
                pessoas.stream().collect(Collectors.groupingBy(Pessoa::getCidade));

        List<Pessoa> salvador1 = pessoasAgrupadasPorCidade.get("Salvador");
        System.out.println("pessoas de salvador "+ salvador1);

        List<Pessoa> saoPaulo = pessoasAgrupadasPorCidade
                .getOrDefault("Sao Paulo", Collections.emptyList());


    }


}


