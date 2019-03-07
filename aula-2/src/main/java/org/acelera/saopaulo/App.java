package org.acelera.saopaulo;

import org.acelera.saopaulo.comportamento.Digitador;

public class App {

    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        PiadaRuim piadaRuim = new PiadaRuim();
        Digitador.digitar(piadaRuim.contar());
        piadaRuim.variavel = "novo valor";
        Digitador.digitar(PiadaRuim.variavel);

        PiadaRuimMesmo heranca = new PiadaRuimMesmo();
        Digitador.digitar(heranca.contar());
        PiadaRuim.variavel = "mudando o valor";
        Digitador.digitar(PiadaRuim.variavel);
        TipoPiada.BOA.reagir();
    }
}
