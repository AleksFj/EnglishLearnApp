package main.ui;

import main.program.tasks.CompleteTranslation;

public class AFCompleteTranslationPanel extends AFLessonPanel {

    private final CompleteTranslation lesson;

    public AFCompleteTranslationPanel(CompleteTranslation lesson) {
        this.lesson = lesson;
        getTaskName(lesson.getTitleText());
        getOriginalText(lesson.getOriginalText());
        //System.out.println("text with missing words = " + lesson.getTextWithMissingWord());
        getTextWithEmptyField(lesson);
        getResultText();

        System.out.println(lesson);
        //System.out.println("CompleteTranslation: " + lesson.getHiddenWord());
    }

    @Override
    public boolean checkLesson() {
        boolean result = lesson.getHiddenWord().equalsIgnoreCase(getHiddenText());
        getResultText().setResult(result);

        System.out.println(lesson.getHiddenWord() + " => " + getHiddenText() + " = " + result);

        return result;
    }
}
