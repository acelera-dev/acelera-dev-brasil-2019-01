package org.acelera.saopaulo;

public class FiltroMaior implements Filtro {

    @Override
    public boolean atende(Pessoa pessoa) {
        return pessoa.getIdade() > 18;
    }

}
