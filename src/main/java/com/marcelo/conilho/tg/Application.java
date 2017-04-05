package com.marcelo.conilho.tg;

import com.marcelo.conilho.tg.model.Studant;
import com.marcelo.conilho.tg.repository.StudantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Autowired
	private StudantRepository studantRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		studantRepository.save(new Studant(123456, "Marcelo"));
		return application.sources(Application.class);
	}
}