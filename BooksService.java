/**
 * 
 */
package com.saeed.assignment.restdemo.service;

/**
 * @author Saeed
 *
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saeed.assignment.restdemo.model.Book;
import com.saeed.assignment.restdemo.repository.BooksRepository;

//defining the business logic  
@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

//getting all books record by using the method findaAll() of CrudRepository  
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		booksRepository.findAll().forEach(book -> books.add(book));
		return books;
	}

//getting a specific record by using the method findById() of CrudRepository  
	public Book getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Book book) {
		booksRepository.save(book);
	}

//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id) {
		booksRepository.deleteById(id);
	}

//updating a record  
	public void update(Book book, int bookid) {
		booksRepository.save(book);
	}
}