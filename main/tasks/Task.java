package main.tasks;

//задание
public abstract class Task {

    protected String text;
    protected boolean isDone = false;

    public Task() {

    }

    public String getText() {
        return text;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public abstract boolean isCorrect();
}
