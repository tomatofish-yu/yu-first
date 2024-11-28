package test;

import dbUtils.Connect;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseConnectionTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Connect.loadProperties("resources/database.properties");
            conn = Connect.connectMySQL();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Successfully connected to the database.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    Connect.closeMySQL();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
