import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks;
    private final String path = "tasks.txt";

    TaskManager(){
        loadExistingTasks();
    }

    private void loadExistingTasks(){
        /*
        * Load
        * */
        try(FileReader reader = new FileReader(path)){
            String line;

        }catch(Exception e){

        }
    }


    public void displayAllTasks(){
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void addTask(String taskDescription){
        int taskId = tasks.size()+1;
        Task newTask = new Task(taskId, taskDescription, TaskStatus.PENDING);
        tasks.add(newTask);
        displayTasks();
    }

    public void deleteTask(int taskId){

    }

    public void updateTask(int taskId,TaskStatus newStatus){

    }

    public void displayTask(TaskStatus status){

    }

    public void saveTask(){
        try(FileWriter writer = new FileWriter(path)){
            writer.write(tasks.toString());
        }catch (Exception e){
            System.err.println(e);
        }
    }

}
