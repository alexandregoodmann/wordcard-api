package com.goodmann.wordcardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.repository.WordRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	public void addWord(WordDefinition definition) {
		if (!this.wordRepository.findByHeadword(definition.getHeadword()).isPresent()) {
			this.wordRepository.save(definition);
		}
	}
}
