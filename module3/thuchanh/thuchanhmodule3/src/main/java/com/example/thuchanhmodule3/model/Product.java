package com.example.thuchanhmodule3.model;

public class Product {
    private int id;
    private String productName;
    private double price;
    private int quantily;
    private String color;
    private String status;
    private String catelory;
    public Product(){}
    public Product(int id, String productName, double price, int quality, String color, String status,String catelory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantily = quality;
        this.color = color;
        this.status = status;
        this.catelory = catelory;
    }

    public Product(String productName, double price, int quantily, String color, String status, String catelory) {
        this.productName = productName;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
        this.status = status;
        this.catelory = catelory;
    }

    public String getCatelory() {
        return catelory;
    }

    public void setCatelory(String catelory) {
        this.catelory = catelory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
