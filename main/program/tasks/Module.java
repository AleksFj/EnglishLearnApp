package main.program.tasks;

import main.program.events.IChangeListener;
import main.program.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Module {
    private final String title; //task topic
    private int current = 0;

    private final ArrayList<Task> taskList = new ArrayList<>();
    private transient List<IChangeListener> listeners = new ArrayList<>();

    public Module(String title) {
        this.title = title;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public String getTitle() {
        return this.title;
    }

    public int current() {
        return current;
    }

    public Module add(Task task) {
        task.setModule(this);
        taskList.add(task);
        return this;
    }

    public Module shuffle() {
        Collections.shuffle(taskList.subList(1, taskList.size()));
        return this;
    }

    public int total() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public Task currentTask() {
        if (current >= total()) return null;
        return taskList.get(current);
    }

    public Module next() {
        taskList.get(current).setDone(true);
        current++;
        User.getCurrentUser().save();
        //System.out.println("Lesson " + current + "/" + total());
        onValueChanged();
        return this;
    }

    public void addChangeListener(IChangeListener listener) {
        listeners.add(listener);
    }

    public void removeChangeListener(IChangeListener listener) {
        listeners.add(listener);
    }

    private void onValueChanged() {
        for(IChangeListener listener : listeners) {
            listener.onChange();
        }
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Module: " + title + "\n\t" +
                "Tasks: " + taskList + "\n";
    }
}
