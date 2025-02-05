package com.example.Product.Catalog.controller;

import com.example.Product.Catalog.model.Product;
import com.example.Product.Catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct( @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<Product>> filterByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productService.filterProductsByCategory(category));
    }

    @GetMapping(params = "price")
    public ResponseEntity<List<Product>> filterByPriceRange(@RequestParam("price") String priceRange) {
        String[] range = priceRange.split(",");
        Double min = Double.parseDouble(range[0]);
        Double max = Double.parseDouble(range[1]);
        return ResponseEntity.ok(productService.filterProductsByPriceRange(min, max));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,  @RequestBody Product product) {
        return productService.updateProduct(id, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}