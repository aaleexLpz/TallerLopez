package es.taller.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("java")
public class AlexApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlexApplication.class, args);
	}

}