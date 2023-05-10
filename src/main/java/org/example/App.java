package org.example;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public void findRest(String location, Statement statement) throws SQLException {
        String query = String.format("SELECT res_name FROM restaurant WHERE res_location = '%S'", location);

//        String query = "SELECT res_name FROM restaurant WHERE res_location IN ("+location+ ")";
        System.out.println(query);
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
    public void loadMenu(String res, Statement statement) throws SQLException {

        String getResidQuery = String.format("SELECT res_id FROM restaurant WHERE res_name = '%s' ", res);

        String Query = String.format("SELECT food_item FROM menu WHERE res_id = (SELECT res_id FROM restaurant WHERE res_name = '%s' )", res);

        ResultSet resultSet = statement.executeQuery(Query);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {

        App app = new App();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "pass@word1");

        Statement statement = connection.createStatement();

//        app.findRest("Angamally", statement);
        app.loadMenu("res 1", statement);






//        ResultSet resultSet = statement.executeQuery("SELECT * FROM menu");
////        resultSet.absolute(2);
//        while (resultSet.next()){
//            System.out.println(resultSet.getString(2));
//        }


    }
}
