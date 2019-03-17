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
    }, DIVISAO {
    	@Override
    	public int operar(int a, int b) {
    		if(b == 0) {
    			throw new IllegalArgumentException("O divisor não pode ser igual a zero.");
    		}
    		return a / b;
    	}
    };
}
