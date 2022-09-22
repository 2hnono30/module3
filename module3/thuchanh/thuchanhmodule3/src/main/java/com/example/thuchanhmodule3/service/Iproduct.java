package com.example.thuchanhmodule3.service;

import com.example.thuchanhmodule3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface Iproduct {
    List<Product> findAll() throws SQLException;

    void save(Product product) throws SQLException;

    Product findById(int id) throws SQLException;

    void update(int id, Product product) throws SQLException;

    void remove(int id) throws SQLException;

}
