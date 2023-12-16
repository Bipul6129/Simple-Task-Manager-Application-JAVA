package Actions;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DriverConnection.JdbcConnection;

public class completeTask {

    public static void setTaskCompleted(String taskName){
        Connection conn = JdbcConnection.getConnection();
        String sql = "update task set status=1 where taskName=?";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,taskName);
            pst.executeUpdate();
            conn.close();
            LoadData.loadTask();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
