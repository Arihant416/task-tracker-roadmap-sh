public class Task {
    private int taskId;
    private String taskName;
    private TaskStatus taskStatus;
    Task(){
        taskName = "";
        taskStatus = TaskStatus.PENDING;
    }
    Task(String taskName, TaskStatus taskStatus){
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public int getTaskId(){
        return taskId;
    }

    public String getTaskName(){
        return taskName;
    }

    public TaskStatus getTaskStatus(){
        return taskStatus;
    }
}
