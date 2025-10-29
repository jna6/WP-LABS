package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
}
