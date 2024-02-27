package main.ui;

import main.program.tasks.TranslateText;

public class AFTranslateTextPanel extends AFLessonPanel {

    private final TranslateText lesson;

    public AFTranslateTextPanel(TranslateText lesson) {
        this.lesson = lesson;
        getTaskName(lesson.getTitleText());
        getOriginalText(lesson.getTranslatedText()); //текст который дан для перевода
        getTranslationTextArea(lesson.getTranslatedText()); //текст который вводит пользователь
        getResultText();

        System.out.println(lesson);
        //System.out.println("TranslateText: " + lesson.getOriginalText());
    }

    @Override
    public boolean checkLesson() {
        boolean result = lesson.getOriginalText().equalsIgnoreCase(getTranslatedText());
        //System.out.println(lesson.getOriginalText() + " => " + getTranslatedText() + " = " + result);
        getResultText().setResult(result);
        return result;
    }
}
