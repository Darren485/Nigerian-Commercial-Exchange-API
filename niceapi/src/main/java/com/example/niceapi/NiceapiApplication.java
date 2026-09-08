package com.example.niceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class NiceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiceapiApplication.class, args);
	}

}
