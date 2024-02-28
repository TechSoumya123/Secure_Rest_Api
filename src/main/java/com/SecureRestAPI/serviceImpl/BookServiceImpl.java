package com.SecureRestAPI.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SecureRestAPI.exception.BookNotFoundException;
import com.SecureRestAPI.model.Book;
import com.SecureRestAPI.repository.BookRepository;
import com.SecureRestAPI.service.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(Long bookId) {
		return Optional.ofNullable(bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No Book found with this id : " + bookId)));
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Long bookId) {
		Optional<Book> findById = findById(bookId);
		findById.ifPresent(book -> {
			bookRepository.deleteById(book.getId());
		});

	}

}
