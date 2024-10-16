package com.booksrental.bookrental.service;

import com.booksrental.bookrental.model.Book;
import com.booksrental.bookrental.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        // Check if book exists
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        if (existingBook.isPresent()) {
            return bookRepository.save(book);
        } else {
            // Handle case where book doesn't exist (e.g., throw exception)
            throw new RuntimeException("Book not found");
        }
    }

    public void deleteBook(Long id) {
        // Check if book exists
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            // Handle case where book doesn't exist (e.g., throw exception)
            throw new RuntimeException("Book not found");
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Add other methods as needed (e.g., getBookById, etc.)
}
