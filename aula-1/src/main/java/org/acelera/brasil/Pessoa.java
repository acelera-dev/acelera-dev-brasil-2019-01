package org.acelera.brasil;


//nome de class deve começar com capital case

public class Pessoa {

    //private que é o mais protegido
    //default que é visível por pacote
    //protected que é visível por pacote ou por herança
    //public que é a casa da mãe Joana

    private static int contador = 0;

    //constante e deve ser snake_case
    public static final String NOME_PROIBIDO = "Valdemor";

    public static final String THANOS = "Thanos";


    private final String nome;

    //camelCase
    private String nomeComposto;

    private double peso;

    private int idade;

    public String cpf;

    private Pessoa(String nome) {
        this.nome = nome;
    }

   /* quando vc nao define um construtor
   public Pessoa() {
    }*/

    public void correr() {
        System.out.println(nome + " corre");
    }

    void falar() {
        System.out.println(nome + " falar");
    }

    void dormir() {
        System.out.println(nome + " dorme");
    }

    void comer() {
        System.out.println(nome + " comer");
    }


    public String getNome() {
        return nome;
    }

    public static Pessoa nascer(String nome) {
        contador++;
        if (NOME_PROIBIDO.equals(nome)) {
            contador = contador - 2;
        }
        //logica quando nascer Thanos, morre metada das pessoas
        if (THANOS.equals(nome)) {
        	contador = contador - (contador/2);
        }
        return new Pessoa(nome);
    }

    public static int getContador() {
        return contador;
    }
}
