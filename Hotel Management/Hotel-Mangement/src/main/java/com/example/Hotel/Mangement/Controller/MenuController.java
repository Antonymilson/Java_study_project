package com.example.Hotel.Mangement.Controller;

import com.example.Hotel.Mangement.Model.Menu;
import com.example.Hotel.Mangement.Servvice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        // menuService.getAllMenus()[].contains function (menu)
        return ResponseEntity.ok(menuService.addMenu(menu)); // Add a new menu
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus()); // Get all menus
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable String id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok) // Menu found
                .orElse(ResponseEntity.notFound().build()); // Menu not found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuById(@PathVariable String id) {
        menuService.deleteMenuById(id); // Delete menu by ID
        return ResponseEntity.noContent().build(); // Return no content response
    }
}