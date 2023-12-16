package Actions;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DriverConnection.JdbcConnection;

public class deleteTask {
    public static void delTask(String taskName){
        Connection conn = JdbcConnection.getConnection();
        String sql = "delete from task where taskName=?";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,taskName);
            pst.executeUpdate();
            conn.close();
            LoadData.loadTask();
            
        }catch(Exception ex){

        }
    }
}
