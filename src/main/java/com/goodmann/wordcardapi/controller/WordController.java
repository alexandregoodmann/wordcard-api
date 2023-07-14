package com.goodmann.wordcardapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.service.WordService;

@RestController
@RequestMapping(value = "v1/wordcard")
public class WordController extends BaseController<WordDefinition, String> {

	@Autowired
	private WordService service;

	@PostMapping
	public List<WordDefinition> create(@RequestBody List<WordDefinition> models) {
		return this.service.create(models);
	}

}
