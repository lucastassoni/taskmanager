package com.example.taskmanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskmanager.models.Task;

public class TaskDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        // Recebe o objeto Task enviado como extra
        Task task = (Task) getIntent().getSerializableExtra("task");

        TextView tvDetails = findViewById(R.id.tvDetails);

        if (task != null) {
            // Exibe os detalhes usando o método toString() da classe Task
            tvDetails.setText(task.toString());
        } else {
            tvDetails.setText("Tarefa não encontrada.");
        }
    }
}
