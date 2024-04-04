package com.goodmann.wordcardapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goodmann.wordcardapi.dto.ClassesDTO;
import com.goodmann.wordcardapi.model.WordDefinition;

public interface WordRepository extends JpaRepository<WordDefinition, Integer> {

	public List<WordDefinition> findByHeadword(String headword);

	@Query(value = "select wordclass, count(*) as qtd from word_definition wd group by wordclass order by count(*)", nativeQuery = true)
	public List<ClassesDTO> findClasses();

	public List<WordDefinition> findAllByWordclass(String wordclass);

}
