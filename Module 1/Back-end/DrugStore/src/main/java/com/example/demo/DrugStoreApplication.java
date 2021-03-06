package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author jbl
 * this class is the applicatien entry point
 * which boots the rest
 */
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories("com.example.demo.data")
public class DrugStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugStoreApplication.class, args);
	}

}

