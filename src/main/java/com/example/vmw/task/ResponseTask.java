package com.example.vmw.task;

import com.example.vmw.model.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseTask {
  @Autowired
  Task task;

  public ResponseTask(Task task) {
    this.task = task;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }
}
