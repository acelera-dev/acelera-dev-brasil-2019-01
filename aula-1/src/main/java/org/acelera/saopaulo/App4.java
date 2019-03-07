package org.acelera.saopaulo;

import java.util.HashMap;
import java.util.Map;

public class App4 {

    public static void main(String[] args) {

        Map<String, Integer> estoque = new HashMap<>();

        estoque.put("Banana", 3);
        estoque.put("Melao", 5);
        estoque.put("Coca cola", 10);
        estoque.put("Cerveja", 20);
        estoque.put("Vinho Seco vermelho", 1);

        System.out.println("quantidade de banana: " +
                estoque.get("Banana"));

        estoque.forEach((k,v) -> {
        	System.out.println("Chave: " + k.toString() +  "Valor: " + v.toString());
        });
        
        Integer valorBanana = estoque.get("Banana");
        estoque.put("Banana", valorBanana - 2);
        estoque.put("Banana", estoque.get("Banana") - 2);


    }
}
