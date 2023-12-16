package Actions;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DriverConnection.JdbcConnection;
import Models.TaskModel;

public class addTask{

    public static void addNewTask(TaskModel task){
        Connection conn = JdbcConnection.getConnection();
        String sql = "insert into task(taskName,priority) values(?,?)";

        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, task.getTaskName());
            pst.setInt(2, task.getTaskPriority());
            pst.executeUpdate();
            LoadData.loadTask();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
