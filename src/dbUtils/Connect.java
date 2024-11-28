package dbUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Connection conn;

    public static void loadProperties(String fileName) {
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream(fileName)) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties", e);
        }
        driver = prop.getProperty("db.driver");
        url = prop.getProperty("db.url");
        user = prop.getProperty("db.user");
        password = prop.getProperty("db.password");
    }

    public static Connection connectMySQL() {
        try {
           Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn == null) {
                throw new SQLException("Failed to establish database connection.");
            }
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
           throw new RuntimeException("Database connection failed", e);
       }
       return conn;
   }

    public static void closeMySQL() {
        try {
           if (conn != null && !conn.isClosed()) {
               conn.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}