package com.proyecto.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonasApplication.class, args);
	}

}
