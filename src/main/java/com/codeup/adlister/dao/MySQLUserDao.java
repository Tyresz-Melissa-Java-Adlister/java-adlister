package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import javax.servlet.jsp.jstl.core.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            String url = config.getUrl();
            String user = config.getUser();
            String password = config.getPassword();
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: unable to establish a database connection!");
            e.printStackTrace();
        }
    }

    @Override
    public List<User> all() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password);
                users.add(user);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: unable to fetch users from the database!");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public long insert(User user) {
        Long generatedId = null;
        try {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: unable to insert user into the database!");
            e.printStackTrace();
        }
        return generatedId;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
