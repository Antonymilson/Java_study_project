package com.example.Product.Catalog.service;

import com.example.Product.Catalog.model.Product;
import com.example.Product.Catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> filterProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> filterProductsByPriceRange(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    public Optional<Product> updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        });
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}