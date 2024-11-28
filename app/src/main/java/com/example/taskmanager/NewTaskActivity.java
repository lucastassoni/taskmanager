package com.example.taskmanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskmanager.models.Task;
import com.example.taskmanager.network.RetrofitClient;
import com.example.taskmanager.network.TaskService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        EditText edtTitle = findViewById(R.id.edtTitle);
        Spinner spinnerPriority = findViewById(R.id.spinnerPriority);
        RadioGroup rgStatus = findViewById(R.id.rgStatus);
        CheckBox cbNotify = findViewById(R.id.cbNotify);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String priority = spinnerPriority.getSelectedItem().toString();
            boolean notify = cbNotify.isChecked();

            int selectedId = rgStatus.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Por favor, selecione um status.", Toast.LENGTH_SHORT).show();
                return;
            }
            String status = ((RadioButton) findViewById(selectedId)).getText().toString();

            Task newTask = new Task(title, priority, status, notify);

            TaskService service = RetrofitClient.getClient("http://10.0.2.2:8080/tasks").create(TaskService.class);
            service.createTask(newTask).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(NewTaskActivity.this, "Tarefa criada com sucesso!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(NewTaskActivity.this, "Erro ao salvar a tarefa.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(NewTaskActivity.this, "Erro na conexão com o servidor.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
