package org.acelera.brasil;

import java.util.Map;

public class Filtro {

    private final String nome;

    private final  int altura;

    private final  boolean temFoto;

    private Filtro(String nome, int altura, boolean temFoto) {
        this.nome = nome;
        this.altura = altura;
        this.temFoto = temFoto;
    }

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public boolean isTemFoto() {
        return temFoto;
    }

    public static Filtro of(Map<String, String> params) {
        String nome = params.get("nome");
        int altura = Integer.valueOf(params.get("altura"));
        boolean foto = Boolean.valueOf(params.get("foto"));

        if(altura > 300) {
            throw new FiltroInvalidoException("Esse filtro tem uma altura superior a 300 cms");
        }
        return new Filtro(nome, altura, foto);
    }
}
