package main.ui;

import main.tasks.TranslateText;

public class AFTranslateTextPanel extends AFLessonPanel {

    private final TranslateText lesson;

    public AFTranslateTextPanel(TranslateText lesson) {
        this.lesson = lesson;
//        title.setText("Translate text");
//        setText(lesson.getText());
    }

    @Override
    public boolean checkLesson() {
        return false;
    }
}
