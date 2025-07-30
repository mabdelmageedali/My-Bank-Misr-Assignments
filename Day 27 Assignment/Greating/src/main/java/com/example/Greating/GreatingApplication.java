package com.example.Greating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GreatingApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreatingApplication.class, args);
	}
}
