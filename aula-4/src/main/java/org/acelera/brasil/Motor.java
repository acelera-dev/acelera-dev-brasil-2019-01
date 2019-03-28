package org.acelera.brasil;

public class Motor {

    private final String nome;

    public Motor(String nome) {
        this.nome = nome;
    }

    public void ligar() {
        System.out.println("motor ligado da " + nome);
    }
}
