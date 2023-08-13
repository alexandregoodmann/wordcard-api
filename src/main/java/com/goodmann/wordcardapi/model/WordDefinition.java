package com.goodmann.wordcardapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.TypeDef;

import com.mysql.cj.xdevapi.JsonString;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@TypeDef(name = "json", typeClass = JsonString.class)
public class WordDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String headword;
	private String headword_full;
	private String wordclass;
	private String json;

}