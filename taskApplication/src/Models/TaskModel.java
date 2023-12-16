package Models;

public class TaskModel {
    private String taskName;
    private int taskPriority;
    private String taskStatus;

    public TaskModel(String taskName,int taskPriority){
        this.taskName=taskName;
        this.taskPriority=taskPriority;
    }
    public TaskModel(String taskName,int taskPriority,int taskStatus){
        this.taskName=taskName;
        this.taskPriority=taskPriority;
        if(taskStatus==0){
            this.taskStatus="notCompleted";
        }else{
            this.taskStatus="completed";
        }
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    
}
