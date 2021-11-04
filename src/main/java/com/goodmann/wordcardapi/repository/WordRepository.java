package com.goodmann.wordcardapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.goodmann.wordcardapi.model.Word;

public interface WordRepository extends MongoRepository<Word, String> {

	public Word findByWord(String word);
}
