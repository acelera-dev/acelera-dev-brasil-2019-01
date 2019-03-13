package org.acelera.brasil.operacao;

public class Subtracao implements Operacao {

    @Override
    public int executar(int valorA, int valorB) {
        return valorA - valorB;
    }
}
