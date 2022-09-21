package com.example.demo.service;
import com.example.demo.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException;

    void save(Student student) throws SQLException;

    Student findById(int id) throws SQLException;

    void update(int id, Student student) throws SQLException;

    void remove(int id) throws SQLException;



}
