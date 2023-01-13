package edu.dio.beansautowireddispring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.dio.beansautowireddispring.app.CepResponse;
import edu.dio.beansautowireddispring.app.JsonConverter;

@SpringBootApplication
public class BeansAutowiredDiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansAutowiredDiSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(JsonConverter converter) {
		return convertJson -> {
			var json = "{\"cep\": \"01001-000\", \"address\": \"Avenida Paulista\", \"locality\": \"São Paulo\"}";
			CepResponse response = converter.convert(json);
			System.out.println("Dados do CEP: " + response);
		};
	}

}
