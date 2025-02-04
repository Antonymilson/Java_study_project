package com.example.Food_List.controller;

import com.example.Food_List.model.Food;
import com.example.Food_List.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService service;

    @GetMapping
    public List<Food> getAllFoods() {
        return service.getAllFoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable String id) {
        Food food = service.getFoodById(id);
        return food != null ? ResponseEntity.ok(food) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return service.addFood(food);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable String id, @RequestBody Food food) {
        Food updatedFood = service.updateFood(id, food);
        return updatedFood != null ? ResponseEntity.ok(updatedFood) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable String id) {
        service.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}