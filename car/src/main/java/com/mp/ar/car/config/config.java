package com.mp.ar.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class config {
    @Bean("apiConsume")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}


