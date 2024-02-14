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
    protected JPanel enteredWordsPanel; //для слов, которые будет выбирать пользователь
    protected JPanel otherWordsPanel; //для слов, которые пользователь должен выбрать

    public AFTranslateSentencePanel(TranslateSentence lesson) {
        super();

        JPanel forTextPanel = new JPanel();
        forTextPanel.setLayout(new BoxLayout(forTextPanel, BoxLayout.Y_AXIS));

        this.lesson = lesson;
        title.setText(lesson.getTitleText());
        text.setText(lesson.getText());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        titlePanel.add(title);
        textPanel.add(text);
        resultPanel.add(resultText);

        forTextPanel.add(titlePanel);
        forTextPanel.add(textPanel);

        enteredWordsPanel = new JPanel();
        otherWordsPanel = new JPanel();

        add(forTextPanel);
        add(enteredWordsPanel);
        add(otherWordsPanel);
        add(resultPanel);
        addWordsToSelect();
    }

    private void addWordsToSelect() {

        ArrayList<String> words = new ArrayList<>();

        words.addAll(Arrays.asList(lesson.getCorrectWords()));
        words.addAll(Arrays.asList(lesson.getOtherWords()));

        Collections.shuffle(words);

        words.forEach(word -> {
            AFCustomButton btn = new AFCustomButton(word);
            otherWordsPanel.add(btn);

            btn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel parentPanel = (JPanel) btn.getParent();
                    if (parentPanel == otherWordsPanel) {
                        otherWordsPanel.remove(btn);
                        enteredWordsPanel.add(btn);
                    } else if (parentPanel == enteredWordsPanel) {
                        enteredWordsPanel.remove(btn);
                        otherWordsPanel.add(btn);
                    }
                    revalidate();
                    repaint();
                }
            });
        });
    }

    @Override
    public boolean checkLesson() {
        String[] correct = lesson.getCorrectWords();
        String[] entered = getEnteredWords();

        boolean result = Arrays.equals(correct, entered);

        if(result) {
            resultText.setText("Correct");
            resultText.setForeground(Color.green);
            resultText.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        } else {
            resultText.setText("Incorrect");
            resultText.setForeground(Color.red);
            resultText.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }

        System.out.println(Arrays.asList(correct) + " : " + Arrays.asList(entered) + " => " + result);
        return result;
    }

    private String[] getEnteredWords() {
        Component[] components = enteredWordsPanel.getComponents();
        String[] buttonTexts = new String[components.length];

        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JButton button) {
                buttonTexts[i] = button.getText();
            }
        }

        return buttonTexts;
    }
}
