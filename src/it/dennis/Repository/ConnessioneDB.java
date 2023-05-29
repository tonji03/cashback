package it.dennis.Repository;

import java.sql.*;

public class ConnessioneDB {
    private static  String url="jdbc:mysql://localhost:3306/corso_u4dev";
    private static  String username="root";
    private static String password="root";
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,username,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
