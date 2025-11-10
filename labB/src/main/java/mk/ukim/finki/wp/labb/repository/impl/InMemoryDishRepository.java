package mk.ukim.finki.wp.labb.repository.impl;

import mk.ukim.finki.wp.labb.bootstrap.DataHolder;
import mk.ukim.finki.wp.labb.model.Dish;
import mk.ukim.finki.wp.labb.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryDishRepository implements DishRepository {
    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream().filter( d-> d.getDishId().equals(dishId)).findFirst().orElse(null);
    }
}
