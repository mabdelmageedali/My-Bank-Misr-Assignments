package com.example.core;

import com.example.core.component.UserService;
import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Printer;

@SpringBootApplication
@Configuration
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context =
					 new AnnotationConfigApplicationContext(SpringCoreDemoApplication.class)) {

			UserService service = context.getBean(UserService.class);
			service.serve();
		}
	}
}
