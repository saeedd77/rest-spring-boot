package com.saeed.assignment.restdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.saeed.assignment.restdemo.model.Book;
import com.saeed.assignment.restdemo.service.BooksService;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
// To Test Service classes only.
class RestdemoApplicationTests {

	@Autowired
	private BooksService bookService;

	@Test
	void testSaveBook() {
		Book book = new Book();

		book.setBookid(1);
		book.setAuthor("Shakir");
		book.setBookname("Spring");
		book.setPrice(550);
		bookService.saveOrUpdate(book);

		book.setBookid(4);
		book.setAuthor("Saeed");
		book.setBookname("Java");
		book.setPrice(350);
		bookService.saveOrUpdate(book);

		Book retBook = bookService.getBooksById(4);
		System.out.println(retBook);
		assertNotNull(retBook);
		assertEquals(book, retBook, "Books are not same.");

	}

	@Test
	void testGetBookByID() {
		Book book = new Book();
		book.setBookid(4);
		book.setAuthor("Saeed");
		book.setBookname("Java");
		book.setPrice(350);

		Book retBook = bookService.getBooksById(4);
		System.out.println(retBook);
		assertNotNull(retBook);
		assertEquals(book, retBook, "Books are not same.");

		book.setBookid(1);
		book.setAuthor("Shakir");
		book.setBookname("Spring");
		book.setPrice(550);

		retBook = bookService.getBooksById(1);
		System.out.println(retBook);
		assertNotNull(retBook);
		assertEquals(book, retBook, "Books are not same.");

	}

}
