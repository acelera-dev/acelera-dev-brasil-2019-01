package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App5 {

    public static void main(String[] args) {
        Pessoa mario =
                new Pessoa("Mario", "JoinVille", 40);

        Pessoa otavio =
                new Pessoa("Otavio", "Salvador", 20);


        List<Pessoa> bancada = new ArrayList<>();
        bancada.add(mario);
        bancada.add(otavio);
        Predicate<Pessoa> maiorFiltro = p -> p.getIdade() > 18;
        Predicate<Pessoa> ehSalvador = p -> "Salvador".equals(p.getCidade());

		@SuppressWarnings(value = { "unused" })
        List<Pessoa> maior = bancada.stream()
                .filter(maiorFiltro.or(ehSalvador))
                .collect(Collectors.toList());

		@SuppressWarnings(value = { "unused" })
        List<String> nomes = bancada.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());

		@SuppressWarnings(value = { "unused" })
        String nomesVirgula = bancada.stream()
                .map(p -> p.getNome())
                .collect(Collectors.joining(","));

		@SuppressWarnings(value = { "unused" })
        int sum = bancada.stream()
                .mapToInt(p -> p.getIdade()).sum();

        Optional<Integer> reduce = bancada.stream()
                .map(p -> p.getIdade())
                .reduce((a, b) -> Integer.sum(a, b));

        if(reduce.isPresent()) {
			@SuppressWarnings(value = { "unused" })
            Integer somatorio = reduce.get();
        }

        reduce.orElseGet(() -> 23);


    }

}
