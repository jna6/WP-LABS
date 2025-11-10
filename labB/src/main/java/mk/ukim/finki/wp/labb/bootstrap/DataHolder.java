package mk.ukim.finki.wp.labb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.labb.model.Chef;
import mk.ukim.finki.wp.labb.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        dishes.add(new Dish("D1", "Pasta Carbonara", "Italian", 20));
        dishes.add(new Dish("D2", "Sushi Roll", "Japanese", 30));
        dishes.add(new Dish("D3", "Tacos", "Mexican", 15));
        dishes.add(new Dish("D4", "Curry", "Indian", 25));
        dishes.add(new Dish("D5", "Cheeseburger", "American", 10));

        chefs.add(new Chef(1L, "Gordon", "Ramsay", "Expert in fine dining and perfectionist.", List.of(dishes.get(0), dishes.get(4))));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "Loves simple and rustic cooking.", List.of(dishes.get(2))));
        chefs.add(new Chef(3L, "Massimo", "Bottura", "Famous for modern Italian cuisine.", List.of(dishes.get(0), dishes.get(3))));
        chefs.add(new Chef(4L, "Nobu", "Matsuhisa", "Japanese fusion cuisine master.", List.of(dishes.get(1))));
        chefs.add(new Chef(5L, "Thomas", "Keller", "Classic American fine dining chef.", List.of(dishes.get(4))));
    }
}
