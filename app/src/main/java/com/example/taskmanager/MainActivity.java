package com.example.taskmanager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTasks = findViewById(R.id.btnTasks);
        Button btnNewTask = findViewById(R.id.btnNewTask);

        btnTasks.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TaskListActivity.class)));
        btnNewTask.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NewTaskActivity.class)));
    }
}
