import CustomExceptions.IdReassignmentException;

import java.time.*;

public class Task {
    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Task() {}

    Task(int id, String description, TaskStatus taskStatus) {
        this.id = id;
        this.description = description;
        this.status = taskStatus;
        this.createdAt = LocalDateTime.now();
        updateUpdatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(this.id != 0){
            throw new IdReassignmentException("Id cannot be reassigned once it is set");
        }
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return status;
    }

    public void markStatus(TaskStatus status) {
        this.status = status;
    }

    public String getCreatedAt(){
        return createdAt.toString();
    }

    private void updateUpdatedAt(){
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return "Task : {id = " + id + ", description = " + description + ", createdAt = " + createdAt.toString() + ", lastUpdatedAt = " + updatedAt.toString()+" }";
    }
}
