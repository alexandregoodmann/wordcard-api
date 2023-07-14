package com.goodmann.wordcardapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodmann.wordcardapi.model.WordDefinition;

public interface WordRepository extends JpaRepository<WordDefinition, Integer> {

	public Optional<WordDefinition> findByHeadword(String headword);
}
