package lk.oopCoursework1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection(){
        String dbName = "vehiclerental";
        String userName = "root";
        String password = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return connection;
    }
}

//https://www.youtube.com/watch?v=NoPzqahrzp8&t=314s