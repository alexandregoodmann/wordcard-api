package com.goodmann.wordcardapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodmann.wordcardapi.model.Word;
import com.goodmann.wordcardapi.service.WordService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "v1/wordcard")
@Slf4j
public class WordController extends BaseController<Word, String> {

	@Autowired
	private WordService service;

	@Override
	@PostMapping
	public ResponseEntity<Word> create(@RequestBody Word model) {
		try {
			return new ResponseEntity<Word>(this.service.create(model), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error on save word", e);
		}
		return null;
	}
}
