package org.acelera.brasil;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Migracao implements InitializingBean {

    @Autowired
    private PersonRepository repository;

    @Override
    public void afterPropertiesSet() throws Exception {

        repository.save(getPerson("Edimilson", "Recife", 179));
        repository.save(getPerson("Val", "Arya", 179));
        repository.save(getPerson("Jose", "Salvador", 180));
        repository.save(getPerson("Elton", "Cachoeira Paulista", 189));

    }

    private Person getPerson(String nome, String nomeCidade, int altura) {
        Cidade cidade = new Cidade();
        cidade.setNome(nomeCidade);
        cidade.setPais("Brasil");

        Person person = new Person();
        person.setNome(nome);
        person.setAltura(altura);
        person.setFoto("foto");
        person.setCidade(cidade);
        return person;
    }
}
