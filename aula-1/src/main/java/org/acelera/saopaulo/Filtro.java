package org.acelera.saopaulo;

@FunctionalInterface
public interface Filtro {


    boolean atende(Pessoa pessoa);
}
