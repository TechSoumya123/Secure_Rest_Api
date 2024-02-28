package com.SecureRestAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SecureRestAPI.model.Book;
import com.SecureRestAPI.service.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController {

	private BookService bookService;

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/book/{id}")
	public Optional<Book> getById(@PathVariable("id") Long bookId) {
		return bookService.findById(bookId);
	}

	@PostMapping(path = "/addBook")
	public ResponseEntity<Book> addBook(@RequestBody(required = true) @Valid Book book) {
		return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
	}

	@DeleteMapping(path = "/book/delete/{id}")
	public void deleteBook(@PathVariable("id") Long bookId) {
		bookService.deleteBookById(bookId);
	}

}
