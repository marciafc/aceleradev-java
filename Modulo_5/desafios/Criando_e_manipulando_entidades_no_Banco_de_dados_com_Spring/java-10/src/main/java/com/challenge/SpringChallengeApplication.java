package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

}
