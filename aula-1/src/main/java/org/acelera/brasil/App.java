package org.acelera.brasil;

public class App {

    public static void main(String[] args) {

        int idade = 20;
        long idadeMaior = 23L;

        float valorQuebrado = 23.00F;
        float temperatura = 22.0F;
        double temparaturaMaior = 2342423423.23;

        boolean estaChovendo = true;

        System.out.println("O dobro de 2 eh: " + dobro(2));
        System.out.println("O dobro de 2 eh: " + dobro(2L));
        imprimirDobro(4);
        imprimirDobro(8);
        imprimirDobro(10);
        String nome = "Otavio";
        int tamanhoNome = nome.length();

        boolean tamanhoMaiorCinco = tamanhoNome != 5;

        boolean comeceComALetraA= nome.charAt(0) == 'A';
        boolean segundaCondica = tamanhoNome == 3;

        if (tamanhoMaiorCinco || !comeceComALetraA) {
            System.out.println("A execução da minha lógica");
            imprimirNome(nome);
        } else {
            System.out.println("Voce não atendeu a minha condição");
        }
        if(segundaCondica) {
            System.out.println("Olá vc atendeu a minha segunda condicação");
        }

        for (int indice = 0; indice <= 100; indice++) {
            System.out.println(indice);
        }
    }


    private static void imprimirNome(String nome) {
        System.out.println("Olá, " + nome);
    }

    private static int dobro(int valor) {
        System.out.println("utilizando o método em int");
        return valor * 2;
    }

    private static long dobro(long valor) {
        System.out.println("utilizando o método em long");
        return valor * 2L;
    }

    private static void imprimirDobro(int valor) {
        System.out.println("O dobro de " + valor + " eh: " + (valor * 2));
    }

    private static void imprimirDobroQuatro() {
        System.out.println("O dobro de quatro eh: " + (4 * 2));
    }


}
