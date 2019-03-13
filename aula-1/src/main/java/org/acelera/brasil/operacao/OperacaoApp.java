package org.acelera.brasil.operacao;

public class OperacaoApp {

    public static void main(String[] args) {
        Operacao soma = new Soma();
        //Soma soma = new Soma();
        Operacao subtracao = new Subtracao();
        System.out.println("o resultado da soma: " + soma.executar(1, 3));
        System.out.println("o resultado da subtracao: " + subtracao.executar(5, 3));

        //divisao
        //multiplicacao
        //potencia
        //raiz
    }
}
