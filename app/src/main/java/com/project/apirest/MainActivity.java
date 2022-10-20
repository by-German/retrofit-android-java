package com.project.apirest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.project.apirest.adapters.ToDoAdapter;
import com.project.apirest.models.ToDo;
import com.project.apirest.services.ToDoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            // using retrofit and Gson
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // using service
            ToDoService toDoService = retrofit.create(ToDoService.class);

            Call<List<ToDo>> request = toDoService.getToDos();
            request.enqueue(new Callback<List<ToDo>>() {
                @Override
                public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                    List<ToDo> todos = response.body();
                    ToDoAdapter toDoAdapter = new ToDoAdapter(todos, context);
                    RecyclerView recyclerView = findViewById(R.id.rvList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(toDoAdapter);

                }
                @Override
                public void onFailure(Call<List<ToDo>> call, Throwable t) {

                }
            });
        });

    }

}