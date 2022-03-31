package com.example.VRSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VRSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VRSystemApplication.class, args);
	}

}
