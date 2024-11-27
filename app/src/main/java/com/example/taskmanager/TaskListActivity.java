package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class TaskListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        ListView listView = findViewById(R.id.listView);
        TaskAdapter adapter = new TaskAdapter(this, fetchTasks());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Task task = (Task) parent.getItemAtPosition(position);
            Intent intent = new Intent(TaskListActivity.this, TaskDetailsActivity.class);
            intent.putExtra("task", task);
            startActivity(intent);
        });
    }

    private List<Task> fetchTasks() {
        // PRECISA INCLUIR A LOGICA DO RETROFIT
        return new ArrayList<>();
    }
}

