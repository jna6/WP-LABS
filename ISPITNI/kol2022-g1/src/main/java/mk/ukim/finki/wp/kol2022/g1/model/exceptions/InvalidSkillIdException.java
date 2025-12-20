package mk.ukim.finki.wp.kol2022.g1.model.exceptions;

public class InvalidSkillIdException extends RuntimeException {
    public InvalidSkillIdException(Long id) {
        super("Skill with id " + id + " is not found" );
    }
}
