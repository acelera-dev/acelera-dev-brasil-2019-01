package org.acelera.brasil;

public class ExcecaoApp {

    public static void main(String[] args) {
        Integer valor = null;

        try {
            System.out.println(valor +2);
        }catch (NullPointerException exp) {
            System.out.println("aconteceu uma excessao segue o fluxo");
        }
        System.out.println("A ultima linha do codigo");
    }
}
