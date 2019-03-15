package org.acelera.brasil;

@FunctionalInterface
public interface PessoaFiltro {

    boolean filtra(Pessoa pessoa);

}
