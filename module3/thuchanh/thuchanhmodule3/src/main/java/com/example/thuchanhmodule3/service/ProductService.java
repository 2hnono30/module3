package com.example.thuchanhmodule3.service;

import com.example.thuchanhmodule3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;

public class ProductService implements Iproduct {
    private String jdbcURL = "jdbc:mysql://localhost:3306/category?useSSL=false";


    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    String SELECT_ALL_PRODUCTS = "SELECT * FROM category.product";
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
    public List<Product> findAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_PRODUCTS);
            System.out.println(this.getClass() + " findAll : " + statement);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantily = rs.getInt("quantily");
                String color = rs.getString("color");
                String status = rs.getString("status");
                String catelory = rs.getString("catelory");
                Product product = new Product(id,name,price,quantily,color,status,catelory);
                list.add(product);

            }
            connection.close();
        } catch (SQLException sqlException) {

        }
        return list;
    }





    @Override
    public void save(Product product) throws SQLException {
        String INSERT_PRODUCT = "INSERT INTO category.product (name, price, quantily, color, status, catelory) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
        ) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantily());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setString(6, product.getCatelory());


            System.out.println(this.getClass() + " save : " + preparedStatement);
            preparedStatement.execute();

        } catch (SQLException sql) {
            sql.getSQLState();
        }
    }

    @Override
    public Product findById(int id) throws SQLException {
        String USER_BY_ID = "SELECT * FROM product where id = ?";

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID);
        preparedStatement.setInt(1, id);

        System.out.println(this.getClass() + " findById : " + preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantily = rs.getInt("quantily");
            String color = rs.getString("color");
            String status = rs.getString("status");
            String catelory = rs.getString("catelory");

            Product product = new Product(id1,name,price,quantily,color,status,catelory);
            return product;
        }
        return null;
    }

    @Override
    public void update(int id, Product product) throws SQLException {
        String SP_UPDATE_PRODUCT = "call category.new_procedure(?, ?, ?, ?, ?, ?, ?);";

        try (
                Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall(SP_UPDATE_PRODUCT);
        ) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, product.getProductName());
            callableStatement.setDouble(3, product.getPrice());
            callableStatement.setInt(4, product.getQuantily());
            callableStatement.setString(5, product.getColor());
            callableStatement.setString(6, product.getStatus());
            callableStatement.setString(7, product.getCatelory());

            System.out.println(this.getClass() + " update: " + callableStatement);
            callableStatement.execute();
        } catch (SQLException sql) {
        }
    }

    @Override
    public void remove(int id) throws SQLException {
        String DELETE_CUSTOMER_SQL = "DELETE FROM category.product WHERE (id = ?);";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
        ) {
            statement.setInt(1, id);
            System.out.println(this.getClass() + " remove: " + statement);
            statement.execute();
        }
    }
    public List<Product> pageProductSearch(String search) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM category.product where name like ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = Double.parseDouble(String.valueOf(resultSet.getDouble("price")));
                int quantily = Integer.parseInt(String.valueOf(resultSet.getInt("quantily")));
                String color = resultSet.getString("color");
                String status = resultSet.getString("status");
                String catelory = resultSet.getString("catelory");

                Product product = new Product(id, name,price,quantily,color,status,catelory);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
