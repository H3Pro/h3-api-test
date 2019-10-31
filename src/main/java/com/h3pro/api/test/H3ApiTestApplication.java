package com.h3pro.api.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.h3pro.api.test.pessoa"})
@EnableJpaRepositories(basePackages = {"com.h3pro.api.test.pessoa"})
@ComponentScan(basePackages = {"com.h3pro.api.test"})
public class H3ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(H3ApiTestApplication.class, args);
	}

}
