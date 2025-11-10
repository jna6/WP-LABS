package mk.ukim.finki.wp.labb.service;

import mk.ukim.finki.wp.labb.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}
