package com.goodmann.wordcardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodmann.wordcardapi.model.Word;

public interface WordRepository extends JpaRepository<Word, String> {

	public Word findByWord(String word);
}
