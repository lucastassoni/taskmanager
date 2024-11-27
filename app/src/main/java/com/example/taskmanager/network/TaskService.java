package com.example.taskmanager.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TaskService {
    @GET("/tasks")
    Call<List<Task>> getTasks();

    @GET("/tasks/{id}")
    Call<Task> getTask(@Path("id") int id);

    @POST("/tasks")
    Call<Void> createTask(@Query("title") String title, @Query("priority") String priority);
}
