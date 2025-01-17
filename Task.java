import CustomExceptions.IdReassignmentException;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int prevId;
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

    Task(int id, String description, TaskStatus taskStatus, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.description = description;
        this.status = taskStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
        return "{ id = " + id + ", description = " + description + ", status = " + status + ", createdAt = " + createdAt.toString() + ", updatedAt = " + updatedAt.toString()+" }";
    }

    public Task parseTask(String taskString){
        try {
            String content = taskString.substring(taskString.indexOf("{") + 1, taskString.lastIndexOf("}"));

            String[] fields = content.split(", ");

            int id = -1;
            String description = null;
            TaskStatus status = null;
            LocalDateTime createdAt = null;
            LocalDateTime updatedAt = null;

            for (String field : fields) {
                String[] kv = field.split("=");
                String key = kv[0].trim();
                String value = kv[1].trim();

                switch (key) {
                    case "id" -> id = Integer.parseInt(value);
                    case "description" -> description = value;
                    case "status" -> status = TaskStatus.valueOf(value);
                    case "createdAt" -> createdAt = LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    case "updatedAt" -> updatedAt = LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                }
            }
            if(id == -1 || description == null || status == null || createdAt == null || updatedAt == null)return null;
            return new Task(id, description, status, createdAt, updatedAt);
        }
        catch (Exception e){
            System.err.println("Exception occurred with taskString " + taskString + e);
            return null;
        }
    }
}
