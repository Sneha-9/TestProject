package toDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDatabase {
    List<Task> tasks;

    TaskDatabase(){
        tasks = new ArrayList<>();
    }

    void addTask(Task task){
        tasks.add(task);
    }

    void remove(Task task){
        for(Task t : tasks){
            if(t.getId().equals(task.getId())){
                tasks.remove(task);
                break;
            }
        }
    }

    Task getTaskById(String id){
        for(Task t : tasks){
            if(t.getId().equals(id)){
               return t;
            }
        }
        return null;
    }

    List<Task> getTaskByStatus(String status){
        List<Task> res = new ArrayList<>();

        for(Task t : tasks){
            if(t.getStatus().equals(status)){
                res.add(t) ;
            }
        }

        return res;
    }

    List<Task> getAllTask(){
        return tasks;
    }
}
