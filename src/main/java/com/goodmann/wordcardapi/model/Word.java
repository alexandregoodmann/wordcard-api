package com.goodmann.wordcardapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String word;
	private String level;

}