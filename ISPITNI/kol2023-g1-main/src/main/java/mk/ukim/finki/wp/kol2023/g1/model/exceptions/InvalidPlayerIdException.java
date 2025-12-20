package mk.ukim.finki.wp.kol2023.g1.model.exceptions;

public class InvalidPlayerIdException extends RuntimeException {
    public InvalidPlayerIdException(Long id) {
        super("Player with id " + id + " is not found");
    }
}
