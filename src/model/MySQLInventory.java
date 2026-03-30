package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MySQLInventory {

    private static Connection connection;
    private static final String USER = "root";
    private static final String PASSWORD = "#Empire99#";
    private static final String DATABASE_NAME = "tree_resort";

    public static Connection createConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME, USER, PASSWORD);
            }
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionInInitializerError("Oops! MySQL Connection Failed....!");
        }

    }

    public static void iud(String query) {
        try {
            createConnection().createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ResultSet search(String query) throws SQLException {
        return createConnection().createStatement().executeQuery(query);
    }

    public static Connection getConnection() {
        return connection!=null?connection:null;
    }
    
}
