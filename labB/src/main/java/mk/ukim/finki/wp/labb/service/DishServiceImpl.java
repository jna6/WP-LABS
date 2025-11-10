package mk.ukim.finki.wp.labb.service;

import mk.ukim.finki.wp.labb.model.Dish;
import mk.ukim.finki.wp.labb.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
       return dishRepository.findByDishId(dishId);
    }
}
