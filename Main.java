import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * On instantiating TaskManager, all tasks are loaded in the background.
        *
        * */
//        TaskManager taskManager = new TaskManager();
// Try writing to a file and then read the file
        String filePath = "db.json";
        try(FileWriter writer = new FileWriter(filePath)){
            writer.write("[\n");
            for(int i = 0; i < 3; i++){
                Task task = new Task(i, "Some random task", TaskStatus.PENDING);
                writer.write(task.toString() + ",\n");
            }
            writer.write("]");
            System.out.println("Data written in file");
        }catch(Exception e){
            System.err.println(e);
        }
        String content = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            System.out.println("File content: ");
            while((line = reader.readLine())!=null){
                content = content.concat(line);
            }
            System.out.println(content);
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
