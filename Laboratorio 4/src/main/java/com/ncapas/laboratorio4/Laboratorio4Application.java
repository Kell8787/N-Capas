package com.ncapas.laboratorio4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan
public class Laboratorio4Application {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio4Application.class, args);
    }
}
