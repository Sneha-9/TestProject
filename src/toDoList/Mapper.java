package toDoList;


import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private IdGenerator idGenerator;
    private TimeUtil timeUtil;

    Mapper(IdGenerator idGenerator, TimeUtil timeUtil) {
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
    }

    Task mapCreateTaskRequestToTask(CreateTaskRequest createTaskRequest) {
        return new Task(idGenerator, timeUtil, createTaskRequest.getTitle(), Constants.PENDING, createTaskRequest.getDueDate());
    }

    UpdateTaskResponse mapUpdateTaskResponseToTask(Task task) {
        return new UpdateTaskResponse(task.getTitle(), task.getStatus(), task.getDueDate());
    }

    GetTaskResponse mapGetTaskResponseToTask(Task task) {
        return new GetTaskResponse(task.getStatus(), task.getId(), task.getDueDate(), task.getTitle());
    }

    List<GetTaskResponse> mapGetTasksResponseToTask(List<Task> tasks) {
        List<GetTaskResponse> result = new ArrayList<>();

        for (Task task : tasks) {
            result.add(mapGetTaskResponseToTask(task));
        }

        return result;

    }
}
