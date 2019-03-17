package org.acelera.brasil.pessoa;

@FunctionalInterface
public interface PessoaFiltro {

    boolean filtra(Pessoa pessoa);

}
