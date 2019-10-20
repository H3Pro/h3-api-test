package com.h3pro.api.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class H3ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(H3ApiTestApplication.class, args);
	}

	@GetMapping("/test")
	public String welcome() {
		return "Wellcome";
	}
	
	
	@GetMapping("/test/{input}")
	public String congrats(@PathVariable String input) {
		
		return "Its Ok..." + input + " Bye!";
	}
	
}
