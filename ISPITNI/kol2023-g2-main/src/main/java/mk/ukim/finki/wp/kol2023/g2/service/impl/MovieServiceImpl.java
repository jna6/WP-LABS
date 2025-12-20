package mk.ukim.finki.wp.kol2023.g2.service.impl;

import mk.ukim.finki.wp.kol2023.g2.model.Director;
import mk.ukim.finki.wp.kol2023.g2.model.Genre;
import mk.ukim.finki.wp.kol2023.g2.model.Movie;
import mk.ukim.finki.wp.kol2023.g2.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.wp.kol2023.g2.repository.MovieRepository;
import mk.ukim.finki.wp.kol2023.g2.service.DirectorService;
import mk.ukim.finki.wp.kol2023.g2.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static mk.ukim.finki.wp.kol2023.g2.service.specifications.FieldFilterSpecification.*;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public MovieServiceImpl(MovieRepository movieRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new InvalidMovieIdException(id));
    }

    @Override
    public Movie create(String name, String description, Double rating, Genre genre, Long director) {

        Director director1 = directorService.findById(director);
        Movie movie = new Movie(name, description, rating, genre, director1);

        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Long id, String name, String description, Double rating, Genre genre, Long director) {

        Director director1 = this.directorService.findById(director);

        Movie movie = this.findById(id);

        movie.setName(name);
        movie.setDescription(description);
        movie.setRating(rating);
        movie.setGenre(genre);
        movie.setDirector(director1);

        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(Long id) {

        Movie movie = this.findById(id);

        movieRepository.delete(movie);
        return movie;
    }

    @Override
    public Movie vote(Long id) {

        Movie movie = this.findById(id);

        movie.setVotes(movie.getVotes() + 1);

        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> listMoviesWithRatingLessThenAndGenre(Double rating, Genre genre) {

        if(rating == null && genre == null){
            return movieRepository.findAll();
        }
        else if(rating != null && genre != null){
            return movieRepository.findAllByGenreAndRatingLessThan(genre, rating);
        }
        else if(rating != null){
            return movieRepository.findByRatingLessThan(rating);
        }
        else {
            return movieRepository.findAllByGenre(genre);
        }
    }

    @Override
    public Page<Movie> findPage(String name, Genre genre, Long director, Integer pageNum, Integer pageSize) {
        Specification<Movie> specification = Specification
                .where(filterContainsText(Movie.class, "name", name))
                .and(filterEqualsV(Movie.class, "genre", genre))
                .and(filterEquals(Movie.class, "director.id", director));

        return this.movieRepository.findAll(
                specification,
                PageRequest.of(pageNum , pageSize)
        );
    }
}
