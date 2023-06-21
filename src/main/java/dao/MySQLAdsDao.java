package dao;

import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            String query = "SELECT * FROM ads";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Ad ad = new Ad(id, title, description);
                ads.add(ad);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: unable to fetch ads from the database!");
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public long insert(Ad ad) {
        Long generatedId = null;
        try {
            String query = "INSERT INTO ads (title, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: unable to insert ad into the database!");
            e.printStackTrace();
        }
        return generatedId;
    }
}
