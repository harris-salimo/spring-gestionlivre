package com.harrissalimo.gestionlivre.controller;

import com.harrissalimo.gestionlivre.entity.Book;
import com.harrissalimo.gestionlivre.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String index(Model model) {
        model.addAttribute("booksList", bookService.getAllBooks());
        return "books/index";
    }

    @GetMapping("/books/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute(book);
        return "books/add";
    }

    @PostMapping("/books/add")
    public String addValidation(@ModelAttribute("book") Book book, Model model) {
        if (Objects.equals(book.getTitle(), "") || Objects.equals(book.getStatus(), "")) {
            model.addAttribute("book", book);
            return "books/add";
        }

        bookService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/show/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "books/show";
    }

    @GetMapping("/books/remove/{id}")
    public String remove(@PathVariable("id") long id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        return "redirect:/books";
    }
}
