package com.goodmann.wordcardapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "word")
public class Word {

	@Id
	private String id;
	private String word;
	private String level;

}