package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("Twilight", "Fantasy", 3.44));
        books.add(new Book("Pride and Prejudice", "Historical", 4.3));
        books.add(new Book("Gone Girl", "Mystery", 4.12));
        books.add(new Book("Little Women", "Fiction", 4.12));
        books.add(new Book("Me Before You", "Romance", 4.2));
        books.add(new Book("The Shining", "Horror", 4.24));
        books.add(new Book("Steve Jobs", "Biography", 4.14));
        books.add(new Book("The Girl with the Dragon Tattoo", "Fiction", 4.12));
        books.add(new Book("To the Lighthouse", "Classics", 3.8));
        books.add(new Book("A Light in the Attic", "Poetry", 4.36));
    }
}
