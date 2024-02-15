package main.ui;

import main.tasks.CompleteTranslation;

public class AFCompleteTranslationPanel extends AFLessonPanel {

    private final CompleteTranslation lesson;

    public AFCompleteTranslationPanel(CompleteTranslation lesson) {
        this.lesson = lesson;
        getTaskName(lesson.getTitleText());
        getTranslationText(lesson.getText());
        getTextWithEmptyField(lesson.getTextWithMissingWord());
    }

    @Override
    public boolean checkLesson() {
        return false;
    }
}
