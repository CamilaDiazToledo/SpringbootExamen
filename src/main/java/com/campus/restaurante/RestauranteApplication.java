package com.campus.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RestauranteApplication .class, args);
	}

}
