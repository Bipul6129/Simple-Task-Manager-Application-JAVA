package Actions;
import Models.TaskModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import DriverConnection.JdbcConnection;
import GUI_elements.myTable;

public class LoadData {
    public static void loadTask(){
        Connection conn = JdbcConnection.getConnection();
        String sql = "select * from task order by status asc,priority desc;";
        List<TaskModel> taskList = new ArrayList<>();
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                taskList.add(new TaskModel(resultSet.getString("taskName"), resultSet.getInt("priority"), resultSet.getInt("status")));
               
            }
            myTable.setTaskData(taskList);
            conn.close();
        }catch(Exception ex){
            
        }
    }
    
    
}
