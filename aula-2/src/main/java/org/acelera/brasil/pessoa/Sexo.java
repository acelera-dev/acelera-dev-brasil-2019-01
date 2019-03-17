package org.acelera.brasil.pessoa;

import java.util.function.Supplier;

public enum Sexo implements Supplier<String> {
    MASCULINO("Masculino"), FEMINIMO("Feminino");


    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String get() {
        return descricao;
    }

}
