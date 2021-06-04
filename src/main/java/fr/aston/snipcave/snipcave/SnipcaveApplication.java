package fr.aston.snipcave.snipcave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fr.aston.snipcave.snipcave"})
public class SnipcaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnipcaveApplication.class, args);
	}

}
