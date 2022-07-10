package com.ezms.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CrudUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudUserApplication.class, args);
	}
}
