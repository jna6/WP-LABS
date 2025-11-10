package mk.ukim.finki.wp.labb.service;

import mk.ukim.finki.wp.labb.model.Chef;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
}
