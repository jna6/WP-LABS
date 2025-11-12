package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, double rating) {
        return DataHolder.books.stream().filter(book -> book.getTitle().toLowerCase().contains(text.toLowerCase()) && book.getAverageRating() >= rating).toList();
    }

    @Override
    public Book findById(Long id) {
        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Book add(String title, String genre, double rating, Author author) {
        Book book = new Book(title, genre, rating);
        book.setAuthor(author);
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public Book edit(Long id, String title, String genre, double rating, Author author) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
