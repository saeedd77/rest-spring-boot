/**
 * 
 */
package com.saeed.assignment.restdemo.repository;

/**
 * @author Saeed
 *
 */
import org.springframework.data.repository.CrudRepository;
import com.saeed.assignment.restdemo.model.Book;

//repository that extends CrudRepository  
public interface BooksRepository extends CrudRepository<Book, Integer> {
}
