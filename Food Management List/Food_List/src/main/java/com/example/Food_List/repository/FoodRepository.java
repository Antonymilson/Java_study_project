package com.example.Food_List.repository;

import com.example.Food_List.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {

}
