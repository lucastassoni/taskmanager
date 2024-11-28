package com.example.taskmanager.models;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String title;
    private String priority;
    private boolean completed;
    private String status; // Campo adicional para status
    private boolean notify; // Campo adicional para notificação

    // Construtor com todos os parâmetros
    public Task(String title, String priority, String status, boolean notify) {
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.notify = notify;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Título: " + title + "\n" +
                "Prioridade: " + priority + "\n" +
                "Status: " + status + "\n" +
                "Notificar: " + (notify ? "Sim" : "Não") + "\n" +
                "Concluído: " + (completed ? "Sim" : "Não");
    }
}
