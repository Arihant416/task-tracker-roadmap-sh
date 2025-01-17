import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks;
    private final String path = "tasks.json";

    TaskManager(){
//        loadExistingTasks();
    }

    private void loadExistingTasks() throws Exception {
        String data = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line ;
            while((line = reader.readLine()) != null){
                System.out.println("Length of line " + line + line.length());
            }
        }catch(Exception e){
            System.err.println("Exception occurred while loading existing tasks "+ e);
            throw new Exception("Some exception occurred " + e);
        }
    }


    public void displayAllTasks(){
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void addTask(String taskDescription){
        int taskId = tasks.size()+1;
//        Task newTask = new Task(1, "taskDescription", TaskStatus.PENDING);
//        tasks.add(newTask);
//        displayTasks();
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
