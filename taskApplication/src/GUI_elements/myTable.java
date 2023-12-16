package GUI_elements;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Models.TaskModel;

public class myTable {
    private static Object[][] taskData;
    private static String[] colNames = {"Task","Priority","Status"};
    private static JTable table;
    public static JTable getTable(){
        DefaultTableModel tableModel = new DefaultTableModel(taskData,colNames);
        table = new JTable(tableModel);
        table.setBackground(Color.LIGHT_GRAY);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return table;
    }

    public static void setTaskData(List<TaskModel> taskList){
        Object[][] tempArray={};
        for (TaskModel taskModel : taskList) {
            Object[] newData = {taskModel.getTaskName(),taskModel.getTaskPriority(),taskModel.getTaskStatus()};

            tempArray = appendData(tempArray,newData);
            
        }
        taskData=tempArray;
        
        if(table!=null){
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setDataVector(taskData, colNames);
            tableModel.fireTableDataChanged();
        }
    }

    private static Object[][] appendData(Object[][] originalArray, Object[] newData) {
        int numRows = originalArray.length;
        int numCols = 3;

    
        Object[][] newArray = new Object[numRows + 1][numCols];


        for (int i = 0; i < numRows; i++) {
            System.arraycopy(originalArray[i], 0, newArray[i], 0, numCols);
        }

        System.arraycopy(newData, 0, newArray[numRows], 0, numCols);

        return newArray;
    }
}
