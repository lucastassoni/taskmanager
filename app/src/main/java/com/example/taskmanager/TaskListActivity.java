package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskmanager.models.Task;
import com.example.taskmanager.network.RetrofitClient;
import com.example.taskmanager.network.TaskService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        ListView listView = findViewById(R.id.listView);
        taskAdapter = new TaskAdapter(this, taskList);
        listView.setAdapter(taskAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Task task = (Task) parent.getItemAtPosition(position);
            Intent intent = new Intent(TaskListActivity.this, TaskDetailsActivity.class);
            intent.putExtra("task", task);
            startActivity(intent);
        });

        fetchTasks();
    }

    private void fetchTasks() {
        TaskService service = RetrofitClient.getClient("http://10.0.2.2:8080/tasks").create(TaskService.class);
        service.getTasks().enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    taskList.clear();
                    taskList.addAll(response.body());
                    taskAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(TaskListActivity.this, "Erro ao carregar as tarefas.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Erro na conexão com o servidor.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
