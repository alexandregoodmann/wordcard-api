package com.goodmann.wordcardapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodmann.wordcardapi.model.WordDefinition;

public interface WordRepository extends JpaRepository<WordDefinition, Integer> {

	public List<WordDefinition> findByHeadword(String headword);
}
