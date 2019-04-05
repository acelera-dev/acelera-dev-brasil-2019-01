package org.acelera.brasil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;


    @BeforeEach
    public void setUp() {
        personRepository.deleteAll();
    }

    @Test
    @DisplayName("Deve inserir no banco de dados usando mongoDB")
    public void deveInserirNoBancoDados() {

        Cidade cidade = new Cidade();
        cidade.setNome("Recife");
        cidade.setPais("Brasil");

        Person person = new Person();
        person.setNome("Edimilson Santana");
        person.setAltura(179);
        person.setFoto("foto");
        person.setCidade(cidade);

        Person save = personRepository.save(person);

        Assertions.assertEquals(1, personRepository.count());
        Assertions.assertNotNull(personRepository.findById(save.getId()));
    }


    @Test
    @DisplayName("Deve buscar pelo nome")
    public void shouldFindByName() {
        Cidade cidade = new Cidade();
        cidade.setNome("Recife");
        cidade.setPais("Brasil");

        Person person = new Person();
        person.setNome("Edimilson Santana");
        person.setAltura(179);
        person.setFoto("foto");
        person.setCidade(cidade);

        personRepository.save(person);

        Person save = personRepository.findByNome(person.getNome());
        assertNotNull(save);
    }
}