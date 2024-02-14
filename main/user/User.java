package main.user;

import main.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Task> taskList = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void AddTask(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        return name + " " + taskList;
    }

    public String getName() {
        return this.name;
    }
}
