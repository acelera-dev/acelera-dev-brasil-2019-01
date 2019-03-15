package org.acelera.brasil;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BancoDadosApp {

    private static Logger LOGGER = Logger.getLogger(BancoDadosApp.class.getName());

    public static void main(String[] args) {

        Supplier<Pessoa> banco = () -> Pessoa.builder()
                .withNome("Ada")
                .withCidade("Salvador")
                .withPais("Pais")
                .withRg("rg")
                .withCpf("cpf")
                .withEmail("meu-email")
                .build();

        Stream<Pessoa> streamA = Stream.of(pessoa);
        Stream<Pessoa> streamB = Stream.of(pessoaB);
        Stream<Pessoa> concat = Stream.concat(streamA, streamB);

        Optional<Pessoa> cache = Optional.ofNullable(null);

        Consumer<Pessoa> println = System.out::println;
        Consumer<Pessoa> log = p -> LOGGER.info("Olha eu estou logando " + p);
        Consumer<Pessoa> auditoria = log.andThen(println);


        Pessoa pessoa = cache.orElseGet(banco);
        auditoria.accept(pessoa);
    }
}
