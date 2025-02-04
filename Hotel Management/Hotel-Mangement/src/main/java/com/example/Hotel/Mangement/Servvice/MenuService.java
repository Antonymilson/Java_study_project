package com.example.Hotel.Mangement.Servvice;

import com.example.Hotel.Mangement.Model.Menu;
import com.example.Hotel.Mangement.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu); // Add or update menu
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll(); // Fetch all menus
    }

    public Optional<Menu> getMenuById(String id) {
        return menuRepository.findById(id); // Fetch menu by ID
    }

    public void deleteMenuById(String id) {
        menuRepository.deleteById(id); // Delete menu by ID
    }
}