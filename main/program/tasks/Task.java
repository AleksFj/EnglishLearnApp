package main.program.tasks;

//задание
public abstract class Task {
    public final String type = getClass().getSimpleName();
    protected String text;
    protected boolean isDone = false;
    private transient Module module;

    public String getText() {
        return text;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public abstract boolean isCorrect();

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    @Override
    public String toString() {
        return "\ttype: " + type + "\n" +
                "\tisDone: " + isDone + "\n";
    }

    public void setText(String text) {
        this.text = text;
    }
}
