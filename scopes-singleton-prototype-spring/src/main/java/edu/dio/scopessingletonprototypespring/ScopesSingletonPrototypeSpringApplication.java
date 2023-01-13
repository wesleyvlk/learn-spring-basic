package edu.dio.scopessingletonprototypespring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.dio.scopessingletonprototypespring.app.MessageSystem;

@SpringBootApplication
public class ScopesSingletonPrototypeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScopesSingletonPrototypeSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MessageSystem system) {
		return message -> {
			system.sendRegistrationConfirmation();
			system.sendWelcomeMessage();
		};
	}

}
