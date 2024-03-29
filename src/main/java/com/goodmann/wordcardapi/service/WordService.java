package com.goodmann.wordcardapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.goodmann.wordcardapi.model.WordDefinition;
import com.goodmann.wordcardapi.repository.WordRepository;

import reactor.core.publisher.Flux;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	@Value("${pons.secret}")
	private String secret;

	@Value("${pons.url}")
	private String url;

	public List<WordDefinition> search(String word) {
		List<WordDefinition> list = this.wordRepository.findByHeadword(word);
		if (list.isEmpty()) {
			list = this.parseToWordDefinition(this.callPonsAPI(word));
		}
		return list;
	}

	public List<JsonNode> callPonsAPI(String word) {
		String uri = this.url.replaceAll("word", word);
		WebClient client = WebClient.builder().baseUrl(uri).defaultHeader("X-Secret", secret).build();
		Flux<JsonNode> flux = client.get().retrieve().bodyToFlux(JsonNode.class);
		return flux.collect(Collectors.toList()).block();
	}

	public List<WordDefinition> parseToWordDefinition(List<JsonNode> nodes) {
		List<WordDefinition> list = new ArrayList<WordDefinition>();
		if (!nodes.isEmpty()) {
			for (JsonNode hit : nodes.get(0).findValues("hits")) {
				for (JsonNode rom : hit.findValues("roms")) {

					String headword = rom.findValue("headword").asText();

					WordDefinition definition = new WordDefinition();
					definition.setHeadword(headword);
					definition.setHeadword_full(rom.findValue("headword_full").asText());

					if (rom.findValue("wordclass") != null)
						definition.setWordclass(rom.findValue("wordclass").asText());
					
					definition.setJson(rom.toString());
					list.add(definition);

					if (this.wordRepository.findByHeadword(headword).isEmpty())
						this.wordRepository.save(definition);

				}
			}
		}
		return list;
	}

}
