package com.example.taskmanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Task task = (Task) getIntent().getSerializableExtra("task");
        TextView tvDetails = findViewById(R.id.tvDetails);

        tvDetails.setText(task.toString());
    }
}