package org.acelera.saopaulo;

public class Pessoa {

    //default que visivel
    //private que dentro da classe
    //protected por heranca e pacote
    //
    private String nome;

    private String sobrenome;

    private int idade;

    private String cidade;


    protected Pessoa(String nome, String sobrenome, int idade, String cidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cidade = cidade;
    }


    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }


    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }


}
