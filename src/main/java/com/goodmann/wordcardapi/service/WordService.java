package com.goodmann.wordcardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmann.wordcardapi.controller.BusinessException;
import com.goodmann.wordcardapi.model.Word;
import com.goodmann.wordcardapi.repository.WordRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	public Word create(Word word) throws BusinessException {
		Word ret = this.wordRepository.findByWord(word.getWord());
		if (ret != null) {
			throw new BusinessException("This word alread exists");
		}
		return this.wordRepository.save(word);
	}
}
