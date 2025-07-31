package com.example.Personal.Library.Service.Controller;

import com.example.Personal.Library.Service.Model.Book;
import com.example.Personal.Library.Service.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepo bookrepo;

    @GetMapping
    public List<Book> allbooks() {
        return bookrepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getbookbyid(@PathVariable Long id) {
        return bookrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookrepo.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = bookrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setPublisher(updatedBook.getPublisher());
        book.setCopiesAvailable(updatedBook.getCopiesAvailable());

        return bookrepo.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookrepo.deleteById(id);
    }
}
