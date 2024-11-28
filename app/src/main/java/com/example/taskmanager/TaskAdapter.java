package com.example.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taskmanager.models.Task;

import java.util.List;

public class TaskAdapter extends android.widget.ArrayAdapter<Task> {
    private final Context context;
    private final List<Task> tasks;

    public TaskAdapter(@NonNull Context context, @NonNull List<Task> tasks) {
        super(context, R.layout.list_item_task, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_task, parent, false);
        }

        Task task = tasks.get(position);

        TextView titleTextView = convertView.findViewById(R.id.task_title);
        TextView priorityTextView = convertView.findViewById(R.id.task_priority);

        titleTextView.setText(task.getTitle());
        priorityTextView.setText(task.getPriority());

        return convertView;
    }
}
