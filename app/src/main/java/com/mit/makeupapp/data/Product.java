package com.mit.makeupapp.data;

public class Product {
    public int id;
    public String brand;
    public String name;
    public String price;
    public String price_sign;
    public String currency;
    public String image_link;
    public String product_link;
    public String website_link;
    public String description;
    public Object rating;
    public String category;
    public String product_type;

    public Product(int id, String brand, String name, String price, String price_sign, String currency, String image_link, String product_link, String website_link,
                   String description, Object rating, String category, String product_type) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.price_sign = price_sign;
        this.currency = currency;
        this.image_link = image_link;
        this.product_link = product_link;
        this.website_link = website_link;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.product_type = product_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_sign() {
        return price_sign;
    }

    public void setPrice_sign(String price_sign) {
        this.price_sign = price_sign;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getProduct_link() {
        return product_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
