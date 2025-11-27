package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@DependsOn("dataHolder")
public class AuthorRepository {

    private final List<Author> authors = new ArrayList<>();
    @PostConstruct
    public void init() {
        authors.add(new Author("Stephenie", "Meyer", "USA", "Famous for the 'Twilight' saga."));
        authors.add(new Author("Jane", "Austen", "UK", "Renowned for her romantic novels set in British society."));
        authors.add(new Author("Gillian", "Flynn", "USA", "Known for her dark psychological thrillers like 'Gone Girl'."));
        authors.add(new Author("Louisa May", "Alcott", "USA", "Best known for her novel 'Little Women'."));
        authors.add(new Author("Jojo", "Moyes", "UK", "Author of emotional romantic fiction like 'Me Before You'."));
        authors.add(new Author("Stephen", "King", "USA", "Master of horror and suspense, author of 'The Shining'."));
        authors.add(new Author("Walter", "Isaacson", "USA", "Biographer known for 'Steve Jobs' and other tech icons."));
        authors.add(new Author("Stieg", "Larsson", "Sweden", "Creator of the Millennium series, 'The Girl with the Dragon Tattoo'."));
        authors.add(new Author("Virginia", "Woolf", "UK", "Modernist author, wrote 'To the Lighthouse'."));
        authors.add(new Author("Shel", "Silverstein", "USA", "Poet, cartoonist, and author of 'A Light in the Attic'."));

        for (int i = 0; i < Math.min(authors.size(), DataHolder.books.size()); i++) {
            authors.get(i).setId((long) i);
            DataHolder.books.get(i).setAuthor(authors.get(i));
        }

    }
    public List<Author> findAll() {
        return authors;
    }
    public Author findById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public void likeAuthor(Long id){
        Author author = findById(id);
        if (author != null) {
            author.addLike();
        }
    }
}
