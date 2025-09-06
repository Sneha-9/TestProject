package toDoList;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToDoList {
    private IdGenerator idGenerator;
    private TimeUtil timeUtil;
    private Mapper mapper;
    private TaskDatabase taskDatabase;

    public ToDoList(IdGenerator idGenerator, TimeUtil timeUtil, Mapper mapper, TaskDatabase taskDatabase) {
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
        this.mapper = mapper;
        this.taskDatabase = taskDatabase;
    }

    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        Task task = mapper.mapCreateTaskRequestToTask(createTaskRequest);
        taskDatabase.addTask(task);
        return new CreateTaskResponse(task.getId());
    }

    UpdateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        String id = updateTaskRequest.getId();

        Task task = taskDatabase.getTaskById(id);
        taskDatabase.remove(task);

        task.setTitle(updateTaskRequest.getTitle() == null? task.getTitle() : updateTaskRequest.getTitle());
        task.setDueDate(updateTaskRequest.getDueDate() == 0? task.getDueDate() : updateTaskRequest.getDueDate());
        task.setStatus(updateTaskRequest.getStatus() == null? task.getStatus(): updateTaskRequest.getStatus());

        taskDatabase.addTask(task);

        return mapper.mapUpdateTaskResponseToTask(task);

    }

    GetTaskResponse getTask(GetTaskRequest getTaskRequest) {
        String id = getTaskRequest.getId();

        if( id == null){
           return null;
        }

        Task task = taskDatabase.getTaskById(id);
        return mapper.mapGetTaskResponseToTask(task);
    }

    List<GetTaskResponse> getTasks(GetTasksRequest getTasksRequest) {
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
