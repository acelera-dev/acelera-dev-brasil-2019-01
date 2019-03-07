package org.acelera.saopaulo;

public class Pessoa {

    private String nome;

    private String cidade;

    private Integer idade;

    public Pessoa(String nome, String cidade, Integer idade) {
        this.nome = nome;
        this.cidade = cidade;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pessoa{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cidade='").append(cidade).append('\'');
        sb.append(", idade=").append(idade);
        sb.append('}');
        return sb.toString();
    }
}
