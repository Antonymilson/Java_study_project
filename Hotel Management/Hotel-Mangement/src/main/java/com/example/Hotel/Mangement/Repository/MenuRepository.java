package com.example.Hotel.Mangement.Repository;

import com.example.Hotel.Mangement.Model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu, String> {

}