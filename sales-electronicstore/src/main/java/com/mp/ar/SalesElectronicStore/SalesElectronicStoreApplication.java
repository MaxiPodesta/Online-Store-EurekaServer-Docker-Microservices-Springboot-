package com.mp.ar.SalesElectronicStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class SalesElectronicStoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SalesElectronicStoreApplication.class, args);
	}

}
