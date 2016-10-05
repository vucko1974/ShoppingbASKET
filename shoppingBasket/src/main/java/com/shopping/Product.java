package com.shopping;

/**
 * Created by ivanvuckovic on 05/10/2016.
 */
public abstract class Product {

    private String name;

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    private Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
}
