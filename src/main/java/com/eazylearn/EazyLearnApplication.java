package com.eazylearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.eazylearn.repository")
@EntityScan("com.eazylearn.model")
public class EazyLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyLearnApplication.class, args);
	}
}

