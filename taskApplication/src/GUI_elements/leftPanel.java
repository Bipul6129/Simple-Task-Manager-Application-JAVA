package GUI_elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Actions.addTask;
import Actions.completeTask;
import Actions.deleteTask;
import Models.TaskModel;


public class leftPanel extends JPanel{
    JTextField taskNameField,priorityField,deleteTaskNameField;
    Dimension buttDimension = new Dimension(250,40);
    JLabel taskNameLabel,priorityLabel,deleteTaskLabel;
    JButton addTaskBtn,deleteBtn,completedBtn;
    public leftPanel(Dimension dimension){

        taskNameLabel = new JLabel("    Enter TaskName");
        add(taskNameLabel);
        taskNameField = new JTextField(15);
        add(taskNameField);

        priorityLabel = new JLabel("    Enter Priority Level");
        add(priorityLabel);
        priorityField = new JTextField(15);
        add(priorityField);

        add(getRigid(0, 0));
        addTaskBtn = new JButton("Add Task");
        addTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {addTaskListener();
        }});
        add(addTaskBtn);
        
 
        add(getRigid(0, 0));
        add(getRigid(0, 0));

        deleteTaskLabel = new JLabel("    Enter TaskName");
        add(deleteTaskLabel);
        deleteTaskNameField = new JTextField(15);
        add(deleteTaskNameField);

 
        deleteBtn = new JButton("Delete");
        add(deleteBtn);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteTaskNameField.getText()!=""){
                    deleteTask.delTask(deleteTaskNameField.getText());
                }
            }
        });

        completedBtn = new JButton("Completed");
        add(completedBtn);
        completedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteTaskNameField.getText()!=""){
                    completeTask.setTaskCompleted(deleteTaskNameField.getText());
                }
            }
            
        });

        setLayout(new GridLayout(8, 2));
        setSize(dimension);
        setBackground(Color.LIGHT_GRAY);

    }

    private Component getRigid(int width,int height){
        return Box.createRigidArea(new Dimension(width,height));
    }

    private void addTaskListener(){
        String taskName;
        int taskPriority;
        if(!taskNameField.getText().isEmpty()){
            taskName=taskNameField.getText();
            try{
                taskPriority=Integer.parseInt(priorityField.getText());
            }catch(Exception ex){
                return;
            }
            
        }else{
            return;
        }
        TaskModel task = new TaskModel(taskName, taskPriority);
        addTask.addNewTask(task);
    }
}
