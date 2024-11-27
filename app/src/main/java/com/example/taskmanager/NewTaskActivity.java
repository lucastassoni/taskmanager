package com.example.taskmanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

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
            // APLICAR LOGICA DE SALVAR TAREFA USANDO O RETORFIRTT
        });
    }
}

