package org.acelera.saopaulo;

public class FiltroSalvador implements Filtro {
    @Override
    public boolean atende(Pessoa pessoa) {
        return "Salvador".equals(pessoa.getCidade());
    }
}
