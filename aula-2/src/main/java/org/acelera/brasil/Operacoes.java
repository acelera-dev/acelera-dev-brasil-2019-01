package org.acelera.brasil;

public enum Operacoes implements Operacao {

    SOMA {
        @Override
        public int operar(int a, int b) {
            return a + b;
        }
    }, SUBTRACAO {
        @Override
        public int operar(int a, int b) {
            return a - b;
        }
    }, MULTIPLICACAO {
        @Override
        public int operar(int a, int b) {
            return a * b;
        }
    };
}
