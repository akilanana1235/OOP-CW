package lk.oopCoursework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {


    public static Connection DbConnector(){
        String dbName = "vehiclerental";
        String userName = "root";
        String password = "";
        try{
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            return conn;
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return null;
    }
}

//https://www.youtube.com/watch?v=UD5Xf1z8Y-4&list=PLeyMYhyx349ZZLdyNf1I7RODb83UwkJYo&index=14
