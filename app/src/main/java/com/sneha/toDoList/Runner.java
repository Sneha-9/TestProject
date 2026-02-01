package com.sneha.toDoList;

public class Runner {

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        TimeUtil timeUtil = new TimeUtil();

        ToDoList toDoList = new ToDoList(
                idGenerator,
                timeUtil,
                new Mapper(idGenerator, timeUtil),
                new TaskDatabase()
        );

        CreateTaskResponse createTaskResponse = toDoList.createTask(
                new CreateTaskRequest.Builder().withTitle("One").build()
        );

        String createdTaskId = createTaskResponse.getId();

        System.out.println(createTaskResponse);

        UpdateTaskResponse updateTaskResponse = toDoList.updateTask(
                new UpdateTaskRequest.Builder(createdTaskId).withTitle("Two").build()
        );

        System.out.println(updateTaskResponse);

//        GetTaskResponse getTaskResponse = toDoList.getTask(new GetTaskRequest.Builder().withId(createdTaskId).build());
//
//        System.out.println(getTaskResponse);
//
//
//        List<GetTaskResponse> completedTasks = toDoList.getTasks(new GetTasksRequest(Constants.COMPLETED));
//        List<GetTaskResponse> pendingTasks = toDoList.getTasks(new GetTasksRequest(Constants.PENDING));
//
//        System.out.println(completedTasks);
//        System.out.println(pendingTasks);
//

    }

}
