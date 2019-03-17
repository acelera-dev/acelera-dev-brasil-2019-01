package org.acelera.brasil.pessoa;

public class Pessoa {

    private final String nome;

    private final int idade;

    private final String cidade;

    private final String pais;

    private final String rg;

    private final String cpf;

    private final String email;

    private final Sexo sexo;

    Pessoa(String nome, int idade, String cidade, String pais, String rg, String cpf, String email, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.pais = pais;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }
}
