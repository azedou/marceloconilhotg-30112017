package com.marcelo.conilho.tg;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@Configuration
@ComponentScan(basePackages={"com.marcelo.conilho.tg"})
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(Application.class);
	}
}
