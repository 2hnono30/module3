package com.example.usermanager.service;

import com.example.usermanager.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServletlmpl implements IUserDAO{
    private static Map<Integer, User> users;

    static {
        users = new HashMap<>();
        users.put(1, new User(1, "John", "john@codegym.vn", "Hanoi"));
        users.put(2, new User(2, "Bill", "bill@codegym.vn", "Danang"));
        users.put(3, new User(3, "Alex", "alex@codegym.vn", "Saigon"));
        users.put(4, new User(4, "Adam", "adam@codegym.vn", "Beijin"));
        users.put(5, new User(5, "Sophia", "sophia@codegym.vn", "Miami"));
        users.put(6, new User(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public void insertUser(User user) throws SQLException {
        users.put(user.getId(), user);
    }

    @Override
    public User selectUser(int id) {
        return users.get(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        users.remove(id);
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        users.put(user.getId(), user);
        return false;
    }
}
