package com.quiroba.fresas_de_diamante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FresasDeDiamanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FresasDeDiamanteApplication.class, args);
	}

}
