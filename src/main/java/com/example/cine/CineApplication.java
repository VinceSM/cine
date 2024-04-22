package com.example.cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.cine")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.cine.models"})
public class CineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineApplication.class, args);
	}
}
