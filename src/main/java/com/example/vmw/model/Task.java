package com.example.vmw.model;

public class Task {
    public enum StatusType {
        SUCCESS,FAILURE;
    }


    StatusType status;
    String id;

    public Task() {
    }

    public Task(StatusType status, String id) {
        this.status = status;
        this.id = id;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
