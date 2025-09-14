package com.sneha;

import com.sneha.toDoList.*;
import jakarta.websocket.server.PathParam;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodolistController {

    private IdGenerator idGenerator = new IdGenerator();
    private TimeUtil timeUtil = new TimeUtil();
    private Mapper mapper = new Mapper(idGenerator, timeUtil);
    private TaskDatabase taskDatabase = new TaskDatabase();
    private ToDoList toDoList = new ToDoList(idGenerator, timeUtil, mapper, taskDatabase);


    @PostMapping(value = "/todolist/task", produces = "application/json")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        return toDoList.createTask(createTaskRequest);
    }

    @GetMapping(value = "todolist/task/{taskId}", produces = "application/json")
    public GetTaskResponse getTask(@PathVariable("taskId") String taskId) {
        //Remove GetTaskRequest
        return toDoList.getTask(taskId);
    }

    @GetMapping(value = "todolist/tasks", produces = "application/json")
    public List<GetTaskResponse> getTasks(String status){
        //Query params
        return toDoList.getTasks(new GetTasksRequest(status));
    }

    @PutMapping(value = "todolist/task", produces = "application/json")
    public UpdateTaskResponse updateTask(@RequestBody UpdateTaskRequest updateTaskRequest) {
        //Is the path inline with REST
        return toDoList.updateTask(updateTaskRequest);
    }

    @DeleteMapping(value = "todolist/task/{taskId}")
    public boolean deleteTask(@PathVariable String taskId){

        return toDoList.deleteTask(taskId);
    }

}
