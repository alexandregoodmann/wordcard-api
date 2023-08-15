package com.goodmann.wordcardapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.repository.WordRepository;
import com.goodmann.wordcardapi.service.WordService;

@CrossOrigin
@RestController
@RequestMapping(value = "v1/wordcard")
public class WordController {

	@Autowired
	private WordService service;
	
	@Autowired
	private WordRepository repository;

	@GetMapping("/word/{word}")
	public List<WordDefinition> getWord(@PathVariable(required = true, name = "word") String word) {
		return this.service.search(word);
	}
	
	@GetMapping("/word")
	public List<WordDefinition> getWord() {
		return this.repository.findAll();
	}

}
