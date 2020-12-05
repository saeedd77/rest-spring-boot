package com.saeed.assignment.restclientdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class RestClientDemoApplicationTests {

	@Test
	final void testGetBooksJSON() {
		String urlStr = "http://localhost:8080/books";
		String str = Quotation.getBooksJSON(urlStr);
		assertNotNull(str);
	}

	@Test
	final void testGetBookByIDJSON() {
		String urlStr = "http://localhost:8080/book/4";
		String str = Quotation.getBooksJSON(urlStr);
		String gsonStr = "{\"bookid\":4,\"bookname\":\"Java\",\"author\":\"Saeed\",\"price\":350}";
		assertEquals(gsonStr, str, "JSON Not Matched.");
	}

	@Test
	final void testGetBooksUsingTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://localhost:8080/books";
		ResponseEntity<String> response = restTemplate.getForEntity(urlStr, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Rest Get not success.");
	}

	@Test
	final void testGetBookByIDUsingTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://localhost:8080/book/4";
		ResponseEntity<String> response = restTemplate.getForEntity(urlStr, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Rest Get By ID not success.");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root;
		try {
			root = mapper.readTree(response.getBody());
			JsonNode name = root.path("name");
			assertNotNull(name.asText());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
