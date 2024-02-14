package main.tasks;

import java.util.ArrayList;

public class Module {
    private final String title; //task topic
    private ArrayList<Task> taskList = new ArrayList<>();
    private int current = 0;

    public Module(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public Module add(Task task) {
        taskList.add(task);

        System.out.println(taskList.size());

        return this;
    }

    public int count() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public Task currentTask() {
        if (current >= count()) return null;
        return taskList.get(current);
    }

    public Module next() {
        current++;
        return this;
    }

    @Override
    public String toString() {
        return "Module: " + title;
    }
}
