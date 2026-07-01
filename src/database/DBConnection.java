package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Khush@9767";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}