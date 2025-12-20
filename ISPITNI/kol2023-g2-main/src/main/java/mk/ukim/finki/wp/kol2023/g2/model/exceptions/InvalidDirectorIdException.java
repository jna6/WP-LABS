package mk.ukim.finki.wp.kol2023.g2.model.exceptions;

public class InvalidDirectorIdException extends RuntimeException {
    public InvalidDirectorIdException(Long id) {
        super("Director with id " + id + " is not found");
    }
}
