package mk.ukim.finki.wp.labb.repository;

import mk.ukim.finki.wp.labb.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
}
