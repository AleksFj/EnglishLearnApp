package main.ui;

import main.tasks.TranslateSentence;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AFTranslateSentencePanel extends AFLessonPanel {

    private final TranslateSentence lesson;

    public AFTranslateSentencePanel(TranslateSentence lesson) {
        this.lesson = lesson;
        getTaskName(lesson.getTitleText());
        getTranslationText(lesson.getText());
        getChoiceWords(lesson.getAllWords());
        getResultText();
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

        if(result) {
            getResultText().setText("Correct");
            getResultText().setForeground(Color.green);
            getResultText().setBorder(BorderFactory.createLineBorder(Color.green, 2));
        } else {
            getResultText().setText("Incorrect");
            getResultText().setForeground(Color.red);
            getResultText().setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }

        System.out.println(Arrays.asList(correct) + " : " + Arrays.asList(entered) + " => " + result);
        return result;
    }

}
