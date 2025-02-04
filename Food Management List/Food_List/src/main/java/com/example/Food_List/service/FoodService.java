package com.example.Food_List.service;

import com.example.Food_List.model.Food;
import com.example.Food_List.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> getAllFoods() {
        return repository.findAll();
    }

    public Food getFoodById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Food addFood(Food food) {
        return repository.save(food);
    }

    public Food updateFood(String id, Food updatedFood) {
        Food food = repository.findById(id).orElse(null);
        if (food != null) {
            food.setName(updatedFood.getName());
            food.setPrice(updatedFood.getPrice());
            food.setCategory(updatedFood.getCategory());
            return repository.save(food);
        }
        return null;
    }

    public void deleteFood(String id) {
        repository.deleteById(id);
    }
}
