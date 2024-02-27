package main.ui;

import main.program.tasks.Module;
import main.program.tasks.*;

import javax.swing.*;
import java.awt.*;

public class AFMainPanel extends JPanel {

    private Module module;
    private final AFTaskControlPanel controlPanel;

    private AFLessonPanel lessonPanel;
//    private AFCenteredTextPane mainText;
//    private JScrollPane mainTextScroll;

    public AFMainPanel() {
        setLayout(new BorderLayout());
        controlPanel = new AFTaskControlPanel(this);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public void setCurrentModule(Module module) {
        this.module = module;
        showLesson(module.currentTask());
        //System.out.println(module.current() + " - " + module.currentTask());
    }

    public void nextExercise() {
        module.next();
        Task current = module.currentTask();
        showLesson(current);
    }

    private void showLesson(Task lesson) {
        if (lessonPanel != null) {
            remove(lessonPanel);
        }

        if (lesson instanceof Rules) {
            lessonPanel = new AFRulesPanel((Rules) lesson);
            controlPanel.setVisibleButtons(false, true);
        } else if (lesson instanceof CompleteTranslation) {
            lessonPanel = new AFCompleteTranslationPanel((CompleteTranslation) lesson);
            controlPanel.setVisibleButtons(true, false);
        } else if (lesson instanceof TranslateSentence) {
            lessonPanel = new AFTranslateSentencePanel((TranslateSentence) lesson);
            controlPanel.setVisibleButtons(true, false);
        } else if (lesson instanceof TranslateText) {
            lessonPanel = new AFTranslateTextPanel((TranslateText) lesson);
            controlPanel.setVisibleButtons(true, false);
        } else {
            lessonPanel = new AFModuleResultPanel(module);
            controlPanel.setVisibleButtons(false, false);
        }

        assert lessonPanel != null;
        add(lessonPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public Module getModule() {
        return module;
    }

    public AFLessonPanel getLessonPanel() {
        return lessonPanel;
    }

}
