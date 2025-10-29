package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class BookReservation {
    private String bookTitle;
    private String readerName;
    private String readerAddress;
    private int numberOfCopies;
}
