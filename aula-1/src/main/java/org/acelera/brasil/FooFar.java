package org.acelera.brasil;

public class FooFar {


    public static void main(String[] args) {

        for (int indice = 1; indice <= 100; indice++) {
            if (indice % 3 == 0) {
                System.out.println("Foo " + indice);
            } else if (indice % 5 == 0) {
                System.out.println("Baa " + indice);
            }
        }
    }
}
