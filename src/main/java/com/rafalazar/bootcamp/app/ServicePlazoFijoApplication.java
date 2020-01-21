package com.rafalazar.bootcamp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicePlazoFijoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlazoFijoApplication.class, args);
	}

}
