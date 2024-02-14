package main.tasks;

import javax.swing.*;

//урок
public abstract class Lesson extends Task {

    protected final String titleText;
    protected JPanel interactiveTextPanel;

    protected Lesson(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }

}
