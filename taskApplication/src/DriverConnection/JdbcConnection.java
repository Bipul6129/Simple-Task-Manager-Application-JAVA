package DriverConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    private static Connection connection=null;
    private static String url = "jdbc:mysql://localhost:3306/task_manager";
    private static String user = "root";
    private static String password="root";

    public static Connection getConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
