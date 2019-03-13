package org.acelera.brasil.operacao;

public class Soma implements Operacao {

    @Override
    public int executar(int valorA, int valorB) {
        return valorA + valorB;
    }
}
