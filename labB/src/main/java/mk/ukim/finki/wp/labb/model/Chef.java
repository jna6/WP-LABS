package mk.ukim.finki.wp.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Chef {
    Long id;
    String firstName;
    String lastName;
    String bio;
    List<Dish> dishes;
}
