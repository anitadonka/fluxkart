package com.example.fluxkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.repository") // Add
@EntityScan(basePackages = "com.example.model")
public class FluxkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxkartApplication.class, args);
	}

}
