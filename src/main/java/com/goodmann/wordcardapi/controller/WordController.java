package com.goodmann.wordcardapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.service.WordService;

import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(value = "v1/wordcard")
public class WordController {

	@Autowired
	private WordService service;

	@GetMapping("/word/{word}")
	public Mono<String> getWord(@PathVariable(required = true, name = "word") String word) {
		String key = "1b1138b30031b9b8fb2e8d010d8d4afe0f18a1c51c4795c7f3428ec1a51e651f";
		String url = "https://api.pons.com/v1/dictionary?q=" + word + "&l=dept";
		WebClient client = WebClient.builder().baseUrl(url).defaultHeader("X-Secret", key).build();
		return client.get().retrieve().bodyToMono(String.class);
	}

	@PostMapping("/word")
	public void addWord(@RequestBody WordDefinition definition) {
		this.service.addWord(definition);
	}
	
}
