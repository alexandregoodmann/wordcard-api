package com.goodmann.wordcardapi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.goodmann.wordcardapi.service.WordService;

@SpringBootTest
class WebFluxTest {

	@Autowired
	private WordService service;

	// @Test
	void testPonsCall() {
		List<JsonNode> result = this.service.callPonsAPI("lesen");
		this.service.parseToWordDefinition(result);
	}
	
	@Test
	void testSearch() {
		this.service.search("lesen");
	}

}
