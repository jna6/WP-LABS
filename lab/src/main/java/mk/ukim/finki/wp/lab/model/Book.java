package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
    private Long id;
    private Author author;

    public Book(String title, String genre, double averageRating) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }
}
