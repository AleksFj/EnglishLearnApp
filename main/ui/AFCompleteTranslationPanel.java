package main.ui;

import main.tasks.CompleteTranslation;

public class AFCompleteTranslationPanel extends AFLessonPanel {

    private final CompleteTranslation lesson;

    public AFCompleteTranslationPanel(CompleteTranslation lesson) {
        title.setText("Complete translation");
        this.lesson = lesson;
        setText(lesson.getText());
    }

    @Override
    public boolean checkLesson() {
        return false;
    }
}
