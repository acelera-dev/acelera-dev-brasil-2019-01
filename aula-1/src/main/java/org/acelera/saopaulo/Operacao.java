package org.acelera.saopaulo;

@FunctionalInterface
public interface Operacao<T extends Number,U extends Number> {
    int operar(T a, U b);
}
