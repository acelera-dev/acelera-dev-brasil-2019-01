package org.acelera.saopaulo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int indice = 1_000; indice >= 1; indice--) {

            if (indice % 5 == 0 && indice % 3 == 0) {
                System.out.println("foo bar o valor do indice " + indice);
            } else if (indice % 5 == 0) {
                System.out.println("bar " + indice);
            } else if (indice % 3 == 0) {
                System.out.println("foo " + indice);
            }
        }

    }
}
