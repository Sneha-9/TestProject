package com.sneha.toDoList;

import java.util.List;

public class ToDoList {
    private final IdGenerator idGenerator;
    private final TimeUtil timeUtil;
    private final Mapper mapper;
    private final TaskDatabase taskDatabase;

    public ToDoList(IdGenerator idGenerator, TimeUtil timeUtil, Mapper mapper, TaskDatabase taskDatabase) {
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
        this.mapper = mapper;
        this.taskDatabase = taskDatabase;
    }

    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        Task task = mapper.mapCreateTaskRequestToTask(createTaskRequest);
        taskDatabase.addTask(task);
        System.out.println(task.toString());
        return new CreateTaskResponse(task.getId());
    }

    public UpdateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {

       Task task = taskDatabase.update(updateTaskRequest.getId(), updateTaskRequest.getTitle(),updateTaskRequest.getDueDate(),updateTaskRequest.getStatus());

//        task.setTitle(updateTaskRequest.getTitle() == null ? task.getTitle() : updateTaskRequest.getTitle());
//        task.setDueDate(updateTaskRequest.getDueDate() == 0 ? task.getDueDate() : updateTaskRequest.getDueDate());
//        task.setStatus(updateTaskRequest.getStatus() == null ? task.getStatus() : updateTaskRequest.getStatus());
//
//        taskDatabase.addTask(task);

        return mapper.mapUpdateTaskResponseToTask(task);

    }

    public boolean deleteTask(String id){
        Task task = taskDatabase.getTaskById(id);

        taskDatabase.remove(task);
        if(taskDatabase.getTaskById(id) == null){
            return true;
        }
        return false;

    }

    public GetTaskResponse getTask(String id) {
        //String id = getTaskRequest.getId();

        if (id == null) {
            return null;
        }

        Task task = taskDatabase.getTaskById(id);
        return mapper.mapGetTaskResponseToTask(task);
    }

    public List<GetTaskResponse> getTasks(GetTasksRequest getTasksRequest) {
        List<Task> taskList = taskDatabase.getTaskByStatus(getTasksRequest.getStatus());

        return mapper.mapGetTasksResponseToTask(taskList);
    }

//    private <T> boolean filter(
//            GetTaskRequest getTaskRequest,
//            Function<GetTaskRequest, T> requestFunction,
//            Task task,
//            Function<Task, T> taskFunction
//    ) {
//
//        T requestValue = requestFunction.apply(getTaskRequest);
//
//        T value = taskFunction.apply(task);
//
//        return Objects.nonNull(requestValue) && requestValue == value;
//    }

}
