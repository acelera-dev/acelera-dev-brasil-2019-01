package org.acelera.brasil;

public class Pessoa {

    static final String CONSTANTE = "minha constante";

    private final String nome;

    private final String cidade;

    private final String pais;

    private final String rg;

    private final String cpf;

    private final String email;

    private final Sexo sexo;

    Pessoa(String nome, String cidade, String pais, String rg, String cpf, String email, Sexo sexo) {
        this.nome = nome;
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

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }


    public int getIdade() {
        return 1;
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
