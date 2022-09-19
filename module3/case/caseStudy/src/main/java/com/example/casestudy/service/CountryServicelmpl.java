package com.example.casestudy.service;

import com.example.casestudy.model.Country;
import com.example.casestudy.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class CountryServicelmpl implements CountryService {

        private String jdbcURL = "jdbc:mysql://localhost:3306/c5_customermanager?useSSL=false";


        private String jdbcUsername = "root";
        private String jdbcPassword = "123456";


        String SELECT_ALL_COUNTRY = "SELECT * FROM c5_customermanager.country";
        protected Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return connection;
        }


        @Override
        public List<Country> findAllCountry() {

            List<Country> list = new ArrayList<>();
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();

                System.out.println(this.getClass() + " findAll : " + statement);
                ResultSet rs = statement.executeQuery(SELECT_ALL_COUNTRY);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String country = rs.getString("country");

                    Country country1 = new Country(id,country);
                    list.add(country1);
                }
                connection.close();
            } catch (SQLException sqlException) {

            }
            return list;
        }

        @Override
        public void save(Country country) throws SQLException {
            String INSERT_COUNTRY = "INSERT INTO c5_customermanager.country(country) VALUES (?)";

            try (
                    Connection connection = getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY);
            ) {
                preparedStatement.setString(1, country.getCountry());
                System.out.println(this.getClass() + " save : " + preparedStatement);
                preparedStatement.execute();
            } catch (SQLException sql) {
                sql.getSQLState();
            }
        }


        @Override
        public Country findByIdCountry(int id) throws SQLException {
            String USER_BY_ID = "SELECT * FROM country where id = ?";

            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID);
            preparedStatement.setInt(1, id);

            System.out.println(this.getClass() + " findById : " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String country = rs.getString("country");

                Country cus = new Country(id1,country);
                return cus;
            }
            return null;
        }

        @Override
        public void updateCountry(int id, Country country) throws SQLException {
            String SP_UPDATE_CUSTOMER = "call c5_customermanager.sp_updateCountry(?, ?);";
            try (
                    Connection connection = getConnection();
                    CallableStatement callableStatement = connection.prepareCall(SP_UPDATE_CUSTOMER);
            ) {
                callableStatement.setInt(1, id);
                callableStatement.setString(2,country.getCountry());

                System.out.println(this.getClass() + " update: " + callableStatement);
                callableStatement.execute();
            } catch (SQLException sql) {
            }
        }

        @Override
        public void removeCountry(int id) throws SQLException {
            String DELETE_COUNTRY_SQL = "DELETE FROM `c5_customermanager`.`country` WHERE (`id` = ?);";
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_COUNTRY_SQL);
            ) {
                statement.setInt(1, id);
                System.out.println(this.getClass() + " remove: " + statement);
                statement.execute();
            }
        }
    }
