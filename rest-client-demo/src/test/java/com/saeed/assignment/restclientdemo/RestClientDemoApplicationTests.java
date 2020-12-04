package com.saeed.assignment.restclientdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestClientDemoApplicationTests {

	@Test
	final void testGetBooksJSON() {
		String urlStr = "http://localhost:8080/books";
		String str = Quotation.getBooksJSON(urlStr);
		assertNotNull(str);
	}

	@Test
	final void testGetBookJSON() {
		String urlStr = "http://localhost:8080/book/4";
		String str = Quotation.getBooksJSON(urlStr);
		String gsonStr = "{\"bookid\":4,\"bookname\":\"Java\",\"author\":\"Saeed\",\"price\":350}";
		assertEquals(gsonStr, str, "JSON Not Matched.");
	}

}
