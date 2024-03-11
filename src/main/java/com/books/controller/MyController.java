package com.books.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.books.bean.Book;
import com.books.service.Service;


//after using @RestController instead using @Controller we need not to add @ResponseBody in handler to write the text in console screen 
@RestController
public class MyController 
{
	@Autowired
	private Service service;

//	Getting all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksHandler() {
		List<Book> list = this.service.getAllBooks();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

//	Getting specified book of specific id
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookHandler(@PathVariable("id") int id) {
		Book book = this.service.getBook(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

//	creating or adding books... 
//	@RequestBody is used to have data in json format from client i.e postman and set that data in Book class object... 
	@PostMapping("/book")
	public ResponseEntity<Book> createBookHandler(@RequestBody Book book) {
		Book b = null;
		try 
		{
			b = this.service.addBook(book);
//			throw new ArithmeticException("");
			return ResponseEntity.of(Optional.of(b));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	Delete book with specified id...
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBookHandler(@PathVariable("id") int id) {
		try {
			this.service.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.DESTINATION_LOCKED).build();
		}
	}

//	Update the specified data record...
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book, @PathVariable("id") int id) {
		Book b = null;
		try {
			b = this.service.updateBook(book, id);
//			this.service.deleteAuthor(book.getAuthor().getId());
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}