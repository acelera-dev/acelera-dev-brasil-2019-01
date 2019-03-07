package org.acelera.saopaulo;

public class PiadaRuimMesmo extends PiadaRuim {

    public PiadaRuimMesmo() {
        this.profissao = "Policial";
    }

    @Override
    public String darRisada() {
        return super.darRisada() +  "lol";
    }
}
