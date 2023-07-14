package com.goodmann.wordcardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.googdmann.wordcardapi" })
public class WordcardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordcardApiApplication.class, args);
	}

}
