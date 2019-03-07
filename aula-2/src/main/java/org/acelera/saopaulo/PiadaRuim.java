package org.acelera.saopaulo;

public class PiadaRuim implements Piada, StandUpComedy {

    protected String profissao = "Engenheiro";

    public static String variavel = "aqui";

    @Override
    public String contar() {
        return profissao + " Civil, ha ha ha";
    }

    @Override
    public String getTipo() {
        return null;
    }

    @Override
    public String darRisada() {
        return "ha ha ha";
    }


    public static void asdf() {

    }
}
