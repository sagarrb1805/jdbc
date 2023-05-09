package org.example;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "pass@word1");

        Statement statement = connection.createStatement();

    }
}
