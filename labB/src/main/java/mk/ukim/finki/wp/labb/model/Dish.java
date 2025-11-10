package mk.ukim.finki.wp.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {
    String dishId;
    String name;
    String cuisine;
    int preparationTime;
}
