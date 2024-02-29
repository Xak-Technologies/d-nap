package com.xakt.dnap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DNapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DNapApplication.class, args);
		
		System.out.println("WELCOME TO XAK-T");
	}

}
