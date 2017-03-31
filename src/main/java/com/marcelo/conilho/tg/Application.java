package com.marcelo.conilho.tg;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.google.common.io.Resources.getResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws FileNotFoundException {

		SpringApplication.run(Application.class, args);
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setServiceAccount(new FileInputStream(getResource("MarceloConilhoTG-9d7694846529.json").getPath()))
				.setDatabaseUrl("https://marceloconilhotg.firebaseio.com/")
				.build();
		FirebaseApp.initializeApp(options);
	}
	 @Override
    	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
