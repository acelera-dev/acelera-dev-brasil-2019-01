package org.acelera.saopaulo;

@FunctionalInterface
public interface Operacao<T, U> {
	int apply(T var1, U var2);
}