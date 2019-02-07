package com.openwebinars;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MovieAdivsorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAdivsorApplication.class, args);
		MovieAdvisorRunApp runApp = new MovieAdvisorRunApp();
		runApp.run(args);
		
	}

}

