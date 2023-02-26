package com.opensource.BookCatalogAPI.service;

import com.opensource.BookCatalogAPI.model.Books;
import com.opensource.BookCatalogAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    public Optional<Books> updateBook(Long id, Books updatedBook) {
        Optional<Books> book = bookRepository.findById(id);

        if (book.isPresent()) {
            Books currentBook = book.get();

            currentBook.setTitle(updatedBook.getTitle());
            currentBook.setAuthor(updatedBook.getAuthor());
            currentBook.setIsbn(updatedBook.getIsbn());
            currentBook.setYear(updatedBook.getYear());

            return Optional.of(bookRepository.save(currentBook));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteBook(Long id) {
        Optional<Books> book = bookRepository.findById(id);

        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return true;
        } else {
            return false;
        }
    }
}
