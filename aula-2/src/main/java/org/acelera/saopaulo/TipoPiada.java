package org.acelera.saopaulo;

public enum  TipoPiada implements ReacaoPiada {
    RUIM{
        @Override
        public String reagir() {
            return "Nossa, repudio :`(";
        }
    },BOA{
        @Override
        public String reagir() {
            return "ha ha ha lol";
        }
    };


}
