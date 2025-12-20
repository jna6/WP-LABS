package mk.ukim.finki.wp.kol2023.g2.repository;

import mk.ukim.finki.wp.kol2023.g2.model.Genre;
import mk.ukim.finki.wp.kol2023.g2.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaSpecificationRepository<Movie, Long>{

    List<Movie> findAllByGenre(Genre genre);
    List<Movie> findByRatingLessThan(Double rating);
    List<Movie> findAllByGenreAndRatingLessThan(Genre genre, Double rating);
}
