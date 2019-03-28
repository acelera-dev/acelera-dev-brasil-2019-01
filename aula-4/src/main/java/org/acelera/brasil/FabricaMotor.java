package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FabricaMotor {


    @Bean
    public Motor getFiat() {
        return new Motor("Fiat");
    }

    @Bean
    @Qualifier("ferrari")
    public Motor getFerrari() {
        return new Motor("Ferrari");
    }
}
