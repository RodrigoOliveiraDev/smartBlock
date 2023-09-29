package com.projetct.smartBlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SmartBlockApplication {



	public static void main(String[] args) {
		SpringApplication.run(SmartBlockApplication.class, args);
	}

	@RestController
	class HttpController {
		@GetMapping("/public")
		public String publicRoute (){
			return "teste";
		}
	}
}
