package mk.ukim.finki.wp.kol2022.g1.model.exceptions;

public class InvalidEmployeeIdException extends RuntimeException {
    public InvalidEmployeeIdException(Long id) {
        super("Employee with id " + id + " is not found");
    }
}
