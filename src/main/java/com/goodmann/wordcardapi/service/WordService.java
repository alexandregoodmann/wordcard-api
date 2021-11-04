package com.goodmann.wordcardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmann.wordcardapi.model.Word;
import com.goodmann.wordcardapi.repository.WordRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	public Word create(Word word) throws Exception {
		Word ret = this.wordRepository.findByWord(word.getWord());
		if (ret != null) {
			throw new Exception("Word already added");
		}
		return this.wordRepository.save(word);
	}
}
