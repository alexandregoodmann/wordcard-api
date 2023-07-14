package com.goodmann.wordcardapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmann.wordcardapi.controller.BusinessException;
import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.repository.WordRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	public List<WordDefinition> create(List<WordDefinition> words) throws BusinessException {
		words.forEach(word -> {
			Optional<WordDefinition> option = this.wordRepository.findByHeadword(word.getHeadword());
			if (!option.isPresent()) {
				word = this.wordRepository.save(word);
			}
		});
		return words;
	}
}
