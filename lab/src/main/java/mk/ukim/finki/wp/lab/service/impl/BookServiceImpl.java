package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book add(String title, String genre, double rating, Long authorId) {
        Author author = authorRepository.findById(authorId);
        return bookRepository.add(title, genre, rating, author);
    }

    @Override
    public Book edit(Long id, String title, String genre, double rating, Long authorId) {
        Book book = findById(id);
        if (book != null) {
            book.setTitle(title);
            book.setGenre(genre);
            book.setAverageRating(rating);
            book.setAuthor(authorRepository.findById(authorId));
        }
        return book;
    }
    
    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
