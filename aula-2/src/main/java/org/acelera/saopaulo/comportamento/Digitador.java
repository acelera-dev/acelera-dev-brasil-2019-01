package org.acelera.saopaulo.comportamento;

import java.util.Random;

public class Digitador {

    private static long ultimoTempo = System.currentTimeMillis();
    private static long contadorTempo = 0;
    private final static int DEMORA_MAXIMA = 300;
    private final static int DEMORA_MINIMA = 170;

    public static void digitar(String mensagem){
        int posicaoLetraAtual = 0;

        while (posicaoLetraAtual < mensagem.length()){

            if(contadorTempo > new Random().nextInt(DEMORA_MAXIMA) + DEMORA_MINIMA) {
                System.out.print(mensagem.charAt(posicaoLetraAtual));
                posicaoLetraAtual++;
                contadorTempo = 0;
            }else{
                contadorTempo += System.currentTimeMillis() - ultimoTempo;
                ultimoTempo = System.currentTimeMillis();
            }
        }
        System.out.println();
    }
}
