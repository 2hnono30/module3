package com.example.demo.service;

import com.example.demo.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImplMysql implements StudentService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/students_case?useSSL=false";


    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    String SELECT_ALL_STUDENTS = "SELECT * FROM students_case.students";

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
    public List<Student> findAll() {

        List<Student> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();


            ResultSet rs = statement.executeQuery(SELECT_ALL_STUDENTS);
            System.out.println(this.getClass() + " findAll : " + statement);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("StudentName");
                String dob = rs.getString("dob");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Student student = new Student(id, name, dob, phone, email, address);
                list.add(student);
            }
            connection.close();
        } catch (SQLException sqlException) {

        }
        return list;
    }

    public int searchCount(String txtSearch) throws SQLException {
        try {
            String query = "SELECT count(*) FROM students_case.students where StudentName like ?";

            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getTotalStudent(){
        String query ="SELECT count(*) FROM students_case.students;";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public List<Student> pageStudentSearch(int index, String search) {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students where StudentName like ? limit ? ,10;";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setInt(2, ((index - 1) * 10));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("StudentName");
                String dob = resultSet.getString("DOB");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Student student = new Student(id, name, dob,phone, email, address);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Student> pageStudent (int index){
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students limit ? ,10";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ((index - 1) * 10));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("StudentName");
                String dob = resultSet.getString("DOB");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Student student = new Student(id, name, dob,phone, email, address);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void save(Student student) throws SQLException {
        String INSERT_STUDENT = "INSERT INTO students_case.students (StudentName, DOB, Phone, email, address,image) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getImage());

            System.out.println(this.getClass() + " save : " + preparedStatement);
            preparedStatement.execute();

        } catch (SQLException sql) {
            sql.getSQLState();
        }
    }

    @Override
    public Student findById(int id) throws SQLException {
        String USER_BY_ID = "SELECT * FROM students where id = ?";

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID);
        preparedStatement.setInt(1, id);

        System.out.println(this.getClass() + " findById : " + preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name = rs.getString("StudentName");
            String dob = rs.getString("dob");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String image = rs.getString("image");


            Student cus = new Student(id1, name, dob, phone, email, address,image);
            return cus;
        }
        return null;
    }

    @Override
    public void update(int id, Student student) throws SQLException {
        String SP_UPDATE_CUSTOMER = "call students_case.sp_updateStudent(?, ?, ?, ?, ?, ?, ?);";

        try (
                Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall(SP_UPDATE_CUSTOMER);
        ) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, student.getName());
            callableStatement.setString(3, student.getDob());
            callableStatement.setString(4, student.getPhone());
            callableStatement.setString(5, student.getEmail());
            callableStatement.setString(6, student.getAddress());
            callableStatement.setString(7, student.getImage());

            System.out.println(this.getClass() + " update: " + callableStatement);
            callableStatement.execute();
        } catch (SQLException sql) {
        }
    }

    @Override
    public void remove(int id) throws SQLException {
        String DELETE_CUSTOMER_SQL = "DELETE FROM `students_case`.`students` WHERE (`ID` = ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
        ) {
            statement.setInt(1, id);
            System.out.println(this.getClass() + " remove: " + statement);
            statement.execute();
        }
    }
}
