package com.harrissalimo.gestionlivre.service;

import com.harrissalimo.gestionlivre.entity.Book;
import com.harrissalimo.gestionlivre.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) throw new RuntimeException("Book not found for ID " + id);

        return optional.get();
    }

    public void insertBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
