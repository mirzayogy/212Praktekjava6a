package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String DB_NAME = "db_212praktek6a";
    private static String TZ = "?serverTimezon=Asia/Makassar";
    private static String USER = "root";
    private static String PASS = "";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            System.out.println("Connecting..");
            connection = DriverManager.getConnection(URL+DB_NAME+TZ,USER,PASS);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection error!");
        }
        return connection;
    }
}
