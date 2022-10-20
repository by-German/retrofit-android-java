package com.project.apirest.services;

import com.project.apirest.models.ToDo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoService {
    @GET("todos")
    Call<List<ToDo>> getToDos();
}
