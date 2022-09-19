package com.example.casestudy.service;

import com.example.casestudy.model.Country;
import com.example.casestudy.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {

        List<Country> findAllCountry() throws SQLException;

        void save(Country country) throws SQLException;

        Country findByIdCountry(int id) throws SQLException;

        void updateCountry(int id, Country country) throws SQLException;

        void removeCountry(int id) throws SQLException;


}
