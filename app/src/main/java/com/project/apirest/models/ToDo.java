package com.project.apirest.models;

public class ToDo {
    int id;
    int userId;
    String title;
    Boolean completed;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
