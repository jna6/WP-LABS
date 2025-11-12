package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, double rating);
    Book findById(Long id);

    Book add(String title, String genre, double rating, Author author);

    Book edit(Long id, String title, String genre, double rating, Author author);
    void delete(Long id);
}
