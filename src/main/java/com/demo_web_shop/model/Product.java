package com.demo_web_shop.model;

public class Product {
    public  String category;
    public String subCategory;
    public String productName;

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public Product setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getProductName() {
        return productName;
    }
}
