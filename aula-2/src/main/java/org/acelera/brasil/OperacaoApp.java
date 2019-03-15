package org.acelera.brasil;

public class OperacaoApp {

    public static void main(String[] args) {
        Operacao operacao = Operacoes.MULTIPLICACAO;
        System.out.println("o resultado da operacao eh: " + operacao.operar(1, 2));
    }
}
