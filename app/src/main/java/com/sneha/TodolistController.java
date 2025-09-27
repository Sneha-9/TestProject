package com.sneha;

import com.google.gson.Gson;
import com.sneha.authenticationService.TokenValidationResponse;
import com.sneha.toDoList.*;
import jakarta.websocket.server.PathParam;
import okhttp3.*;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
public class TodolistController {

    private IdGenerator idGenerator = new IdGenerator();
    private TimeUtil timeUtil = new TimeUtil();
    private Mapper mapper = new Mapper(idGenerator, timeUtil);
    private TaskDatabase taskDatabase = new TaskDatabase();
    private ToDoList toDoList = new ToDoList(idGenerator, timeUtil, mapper, taskDatabase);

    private OkHttpClient client = new OkHttpClient();

    private Gson gson = new Gson();

    @PostMapping(value = "/todolist/task", produces = "application/json")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest createTaskRequest, @RequestHeader("token") String token) throws Exception {
       if(!validateToken(token)){
           throw new Exception("Token is not valid");
       }

       return toDoList.createTask(createTaskRequest);
    }

    @GetMapping(value = "todolist/task/{taskId}", produces = "application/json")
    public GetTaskResponse getTask(@PathVariable("taskId") String taskId,@RequestHeader("token") String token) throws Exception {
        //Remove GetTaskRequest
//        try {
//          ///  sendGET();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if(!validateToken(token) ){
            throw new Exception("Token is not valid");

        }
        return toDoList.getTask(taskId);
    }

    @GetMapping(value = "todolist/tasks", produces = "application/json")
    public List<GetTaskResponse> getTasks(String status,@RequestHeader("token") String token) throws Exception{
        //Query params
        if(!validateToken(token)) {
            throw new Exception("Token is not valid");

        }
        return toDoList.getTasks(new GetTasksRequest(status));
    }

    @PutMapping(value = "todolist/task", produces = "application/json")
    public UpdateTaskResponse updateTask(@RequestBody UpdateTaskRequest updateTaskRequest,@RequestHeader("token") String token) throws Exception {
        //Is the path inline with REST
        if(!validateToken(token)) {
            throw new Exception("Token is not valid");

        }
        return toDoList.updateTask(updateTaskRequest);
    }

    @DeleteMapping(value = "todolist/task/{taskId}")
    public boolean deleteTask(@PathVariable String taskId,@RequestHeader("token") String token) throws Exception{
        if(!validateToken(token)) {
            throw new Exception("Token is not valid");

        }
        return toDoList.deleteTask(taskId);
    }

    private boolean validateToken(String token) throws Exception {
        String url = String.format("http://localhost:8080/authenticationService/validate-token/%s", token);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            TokenValidationResponse validationResponse = gson.fromJson(response.body().string(), TokenValidationResponse.class);
            return validationResponse.isResponse();
        }catch (Exception e) {
          throw  new Exception("There was issue while calling Authentication Service");
        }

    }


//    private static void sendGET() throws IOException {
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://localhost:8080/authenticationService/validate-token/3230cb17-d03e-46d1-a211-0d918d5b5825");
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(
//                        httpResponse.getEntity().getContent()
//                )
//        );
//
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = reader.readLine()) != null) {
//            response.append(inputLine);
//        }
//        reader.close();
//
//        // print result
//        System.out.println(response.toString());
//    }

    class ApiResponse <T>  {
        T data;
        boolean success;
        String errorMessage;

        ApiResponse(T data, boolean success, String errorMessage){
            this.data = data;
            this.success = success;
            this.errorMessage = errorMessage;
        }
    }
}
