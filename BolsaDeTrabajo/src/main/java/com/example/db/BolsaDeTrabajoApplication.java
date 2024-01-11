package com.example.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class BolsaDeTrabajoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolsaDeTrabajoApplication.class, args);
	}

}
