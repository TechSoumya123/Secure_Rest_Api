package com.SecureRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SecureRestAPI.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
