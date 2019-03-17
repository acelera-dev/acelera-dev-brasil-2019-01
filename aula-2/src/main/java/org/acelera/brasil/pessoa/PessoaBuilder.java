package org.acelera.brasil.pessoa;

import java.util.Objects;

public class PessoaBuilder {

    private String nome;

    private String cidade;

    private String pais;

    private String rg;

    private String cpf;

    private String email;

    private Sexo sexo;

    public PessoaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public PessoaBuilder withPais(String pais) {
        this.pais = pais;
        return this;
    }

    public PessoaBuilder withRg(String rg) {
        this.rg = rg;
        return this;
    }

    public PessoaBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PessoaBuilder withSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public Pessoa build() {
        Objects.requireNonNull(nome, "o nome é obrigatorio");
        Objects.requireNonNull(cidade, "o cidade é obrigatorio");
        Objects.requireNonNull(pais, "o pais é obrigatorio");
        return new Pessoa(nome, cidade, pais, rg, cpf, email, sexo);
    }
}