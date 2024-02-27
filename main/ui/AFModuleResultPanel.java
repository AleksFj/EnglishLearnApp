package main.ui;

import main.program.tasks.Module;
import main.program.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class AFModuleResultPanel extends AFLessonPanel {
    public AFModuleResultPanel(Module module) {
        JLabel completed = new JLabel("Completed");
        completed.setFont(Fonts.COURIERNEW_BOLD_32);
        completed.setForeground(Color.green);
        add(completed);
    }

    @Override
    public boolean checkLesson() {
        return false;
    }
}
