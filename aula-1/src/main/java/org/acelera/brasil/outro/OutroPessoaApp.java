package org.acelera.brasil.outro;

import org.acelera.brasil.Pessoa;

public class OutroPessoaApp {

    public static void main(String[] args) {
        Pessoa otavio = Pessoa.nascer("Otavio");
        Pessoa abel = Pessoa.nascer("Abel");
        Pessoa poliana = Pessoa.nascer("Poliana");
        Pessoa ada = Pessoa.nascer("Ada");
        Pessoa valdemor = Pessoa.nascer(Pessoa.NOME_PROIBIDO);

        otavio.cpf = "falha de segurança";
        System.out.println("Qual o seu nome: " + otavio.getNome());
        otavio.correr();
        valdemor.correr();

        abel.correr();
        poliana.correr();
        ada.correr();

        System.out.println("Pessoas que nasceram no mundo de otavio: " + Pessoa.getContador());




    }

    class InnerClass {

    }
}
