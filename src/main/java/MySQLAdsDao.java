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
        // Retrieve all ads from the database and populate a List<Ad>
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ads");
            while (resultSet.next()) {
                // Process each row and create an Ad object
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                // Create an Ad object and add it to the list
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
    public Long insert(Ad ad) {
        Long generatedId = null;
        try {
            String query = "INSERT INTO ads (title, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: unable to insert ad into the database!");
            e.printStackTrace();
        }
        return generatedId;
    }
}
