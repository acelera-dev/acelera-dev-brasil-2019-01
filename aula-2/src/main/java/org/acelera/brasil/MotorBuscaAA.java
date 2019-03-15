package org.acelera.brasil;

import java.util.Locale;
import java.util.function.Function;

public class MotorBuscaAA {

    public static void main(String[] args) {
        String palavra = "   eu amor estar Com VoCes";

        palavra.toLowerCase().trim().toLowerCase(Locale.US);
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> eliminarVazio = String::trim;
        Function<String, String> tratamento = toLowerCase.andThen(eliminarVazio);

        System.out.println(tratamento.apply(palavra));

    }
}
