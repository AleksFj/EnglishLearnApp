package main.ui;

import main.program.tasks.TranslateSentence;

import java.util.Arrays;

public class AFTranslateSentencePanel extends AFLessonPanel {

    private final TranslateSentence lesson;

    public AFTranslateSentencePanel(TranslateSentence lesson) {
        this.lesson = lesson;
        getTaskName(lesson.getTitleText());
        getOriginalText(lesson.getOriginalText());
        getChoiceWords(lesson.getAllWords());
        getResultText();

        System.out.println(lesson);
        //System.out.println("TranslateSentence: " + Arrays.asList(lesson.getCorrectWords()));
    }

    @Override
    public boolean checkLesson() {
        //return true;
        //commented out the working code for the test

        //********************************************************
        //              this is a working code
        //                       ||
        //                       ||
        //                       ||
        //                  \__________/
        //                   \        /
        //                    \      /
        //                     \    /
        //                      \  /
        //                       \/

        String[] correct = lesson.getCorrectWords();
        String[] entered = getEnteredWords();
        boolean result = Arrays.equals(correct, entered);
        getResultText().setResult(result);

        //System.out.println(Arrays.asList(correct) + " => " + Arrays.asList(entered) + " = " + result);

        return result;
    }

}
