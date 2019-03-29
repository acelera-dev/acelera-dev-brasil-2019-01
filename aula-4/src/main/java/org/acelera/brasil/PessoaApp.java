package org.acelera.brasil;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PessoaApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PessoaApp.class);

        PessoaRepository repository = applicationContext.getBean(PessoaRepository.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("mluiz");

        Endereco endereco = new Endereco();
        endereco.setLogradouro("rua Ormadio");

        Telefone trabalho = new Telefone();
        trabalho.setLabel("trabalho");
        trabalho.setNumero("123451");

        Telefone casa = new Telefone();
        casa.setLabel("trabalho");
        casa.setNumero("123451");

        pessoa.setEndereco(endereco);
        pessoa.adicionar(trabalho);
        pessoa.adicionar(casa);

        repository.save(pessoa);
        System.out.println("find all" + repository.findAll());


    }
}
