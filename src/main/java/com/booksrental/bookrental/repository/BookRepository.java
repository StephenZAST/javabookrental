package com.booksrental.bookrental.repository;

import com.booksrental.bookrental.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Add any custom query methods as needed
}
