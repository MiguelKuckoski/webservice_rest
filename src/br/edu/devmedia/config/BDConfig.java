package br.edu.devmedia.config;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class BDConfig {
 
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/rest_devmedia", "postgres", "postgres");
    }
     
}