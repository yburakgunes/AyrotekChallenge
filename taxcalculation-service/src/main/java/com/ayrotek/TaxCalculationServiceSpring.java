package com.ayrotek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaxCalculationServiceSpring {
    public static void main(String[] args) {
        SpringApplication.run(TaxCalculationServiceSpring.class,args);
    }

}
