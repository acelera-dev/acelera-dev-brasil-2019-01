package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Carro {

    @Autowired
    @Qualifier("ferrari")
    private Motor motor;

    public void acelerar() {
        motor.ligar();
        System.out.println("carro em movimento");
    }
}
