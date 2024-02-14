package main.ui;

import main.tasks.Module;
import main.tasks.*;

import javax.swing.*;
import java.awt.*;

public class AFMainPanel extends JPanel {

    private Module taskSubject;
    private AFTaskControlPanel controlPanel;

    private AFLessonPanel lessonPanel;
//    private AFCenteredTextPane mainText;
//    private JScrollPane mainTextScroll;

    public AFMainPanel() {
        setLayout(new BorderLayout());
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        mainText = new AFCenteredTextPane();
//        mainText.setFont(Fonts.COURIERNEW_BOLD_32);
//        mainText.setText("Choosing the right option:");
//        mainText.setEditable(false);
//        mainText.setContentType("text/html");
//
//        mainTextScroll = new JScrollPane(mainText);
//        add(mainTextScroll);
//
//        AFCenteredTextPane label2 = new AFCenteredTextPane();
//        label2.setFont(Fonts.COURIERNEW_BOLD_32);
//        label2.setText("The cat is sleeping on ____ bed.");
//        label2.setEditable(false);
//        add(label2);

        //    JPanel elements = new JPanel(new FlowLayout(FlowLayout.CENTER, new Random().nextInt(10, 60), 10));

        /*
        ---------------- НАЧАЛО: СОЗДАНИЕ КНОПОК ВЫБОРА СЛОВ -----------------
        *-*-*-*-*-*-*-*-*-* ТОЛЬКО ДЛЯ ТЕСТА *-*-*-*-*-*-*-*-*-*
         */
//
//        int rowCount = 0;
//        for (int i = 0; i < 10; i++) {
//            rowCount++;
//            AFCustomButton button = new AFCustomButton("Button " + (i + 1));
//            elements.add(button);
//            if (new Random().nextFloat() > 0.5f) {
//                elements.add(Box.createHorizontalGlue());
//            }
//
//            if ((new Random().nextFloat() > 0.5f && rowCount >= 3) || rowCount >= 4) {
//                add(elements);
//                elements = new JPanel(new FlowLayout(FlowLayout.CENTER, new Random().nextInt(10, 60), 10));
//                rowCount = 0;
//            }
//        }
        /*
        ---------------- КОНЕЦ: СОЗДАНИЕ КНОПОК ВЫБОРА СЛОВ -----------------
        *-*-*-*-*-*-*-*-*-* ТОЛЬКО ДЛЯ ТЕСТА *-*-*-*-*-*-*-*-*-*
         */

        //    add(elements);


        controlPanel = new AFTaskControlPanel(this);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public void setTaskSubject(Module taskSubject) {
        this.taskSubject = taskSubject;

        Task current = taskSubject.currentTask();

        if (lessonPanel != null) {
            remove(lessonPanel);
        }

        if (current instanceof Rules) {
            lessonPanel = new AFRulesPanel((Rules) current);
            controlPanel.setVisibleButtons(false, true);
        } else if (current instanceof CompleteTranslation) {
            lessonPanel = new AFCompleteTranslationPanel((CompleteTranslation) current);
            controlPanel.setVisibleButtons(true, false);
        } else if (current instanceof TranslateSentence) {
            lessonPanel = new AFTranslateSentencePanel((TranslateSentence) current);
            controlPanel.setVisibleButtons(true, false);
        } else if (current instanceof TranslateText) {
            lessonPanel = new AFTranslateTextPanel((TranslateText) current);
            controlPanel.setVisibleButtons(true, false);
        }

        add(lessonPanel, BorderLayout.CENTER);
        revalidate();

//        if (current == null) {
//            mainText.setText("WELL DONE!");
//            controlPanel.setVisibleButtons(false, false);
//            return;
//        }
//
//        mainText.setText(current.getText());
//
//        if (current instanceof Rules) { //если текущее задание это просто правила
//            controlPanel.setVisibleButtons(false, true);
//        } else if (current instanceof ChooseWords) { //если текущее задание, это задание с выбором слов
//            controlPanel.setVisibleButtons(true, false);
//        } else if (current instanceof TranslateText) { //если текущее задание, это задание с переводом текста
//            controlPanel.setVisibleButtons(true, false);
//        }
    }

    public Module getTaskSubject() {
        return taskSubject;
    }

    public AFLessonPanel getLessonPanel() {
        return lessonPanel;
    }

}
