package com.example.Hotel.Mangement.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
public class Menu {
    @Id
    private String id; // Unique identifier for each menu
    private String menuName; // Name of the menu item
    private String menuCategory; // e.g., Main Course, Starter
    private double price; // Price of the menu item
    private String currency; // Currency type, e.g., INR
    private String menuImageUrl; // URL of the menu image
    private String offerName; // e.g., special, weekend offer
    private double offerPercent; // Discount percentage
    private double offerPrice; // Price after discount
    private int quantity; // Available quantity

    // Getters and Setters
    // Optionally, include constructors and a toString() method


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMenuImageUrl() {
        return menuImageUrl;
    }

    public void setMenuImageUrl(String menuImageUrl) {
        this.menuImageUrl = menuImageUrl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getOfferPercent() {
        return offerPercent;
    }

    public void setOfferPercent(double offerPercent) {
        this.offerPercent = offerPercent;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}