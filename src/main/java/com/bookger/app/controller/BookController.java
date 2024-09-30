package com.bookger.app.controller;

import com.bookger.app.model.Book;
import com.bookger.app.repertory.BookRepertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller  // Cambiado de @RestController a @Controller
@RequestMapping("/")
public class BookController {
    private final BookRepertory bookRepertory;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookRepertory bookRepertory) {
        this.bookRepertory = bookRepertory;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookRepertory.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("books", new Book());
        return "addBook";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        bookRepertory.save(book);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepertory.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookRepertory.findByAuthor(author);
    }

    @GetMapping("/publishedYear/{publishedYear}")
    public List<Book> getBookByPublishedYear(@PathVariable int publishedYear) {
        return bookRepertory.findByPublishedYear(publishedYear);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book itemBook){
        Book book = bookRepertory.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(itemBook.getTitle());
        book.setAuthor(itemBook.getAuthor());
        book.setIsnb(itemBook.getIsnb());
        book.setPublishedYear(itemBook.getPublishedYear());

        return bookRepertory.save(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepertory.deleteById(id);
        return "Book deleted!";
    }
}
