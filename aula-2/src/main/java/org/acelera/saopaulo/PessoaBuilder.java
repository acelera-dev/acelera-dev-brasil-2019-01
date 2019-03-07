package org.acelera.saopaulo;

import java.util.Objects;

public class PessoaBuilder {

	private String nome;

	private String sobrenome;

	private int idade;

	private String cidade;

    protected PessoaBuilder() {}

    public PessoaBuilder withNome(String nome) {
    	Objects.requireNonNull(nome, "nome não pode ser null");
        this.nome = nome;
        return this;
    }

    public PessoaBuilder withSobreNome(String sobrenome) {
        Objects.requireNonNull(sobrenome, "sobrenome não pode ser null");
    	this.sobrenome = sobrenome;
        return this;
    }

    public PessoaBuilder withIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public PessoaBuilder withCidade(String cidade) {
    	Objects.requireNonNull(cidade, "cidade não pode ser null");
        this.cidade = cidade;
        return this;
    }
    
    public Pessoa build() {
    	return new Pessoa(nome, sobrenome, idade, cidade);
    }
}
