package main.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AFTaskControlPanel extends JPanel {

    private JLabel countLabel;
    AFCustomButton checkButton;
    AFCustomButton nextButton;

    private AFMainPanel mainPanel;

    public AFTaskControlPanel(AFMainPanel mainPanel) {
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //setBackground(Color.white);
        this.mainPanel = mainPanel;

        checkButton = new AFCustomButton("Проверить");

        checkButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //boolean isCorrect = mainPanel.getLessonPanel().checkLesson();
                if(mainPanel.getLessonPanel().checkLesson()) {
                    setVisibleButtons(false, true);
                }
//                if (mainPanel.getTaskSubject().currentTask().isCorrect()) {
//                    setVisibleButtons(false, true);
//                }
            }
        });

        nextButton = new AFCustomButton("Продолжить");

        nextButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setTaskSubject(mainPanel.getTaskSubject().next());
            }
        });

        add(checkButton);
        add(nextButton);

//        AFCustomButton backButton = new AFCustomButton("<");
//        backButton.setSize(100, 100);
//        backButton.setFont(Fonts.COURIERNEW_BOLD_32);
//
//        AFCustomButton nextButton = new AFCustomButton(">");
//        nextButton.setSize(100, 100);
//        nextButton.setFont(Fonts.COURIERNEW_BOLD_32);
//
//        countLabel = new JLabel("6/9");
//        countLabel.setFont(Fonts.COURIERNEW_BOLD_32);
//
//        add(backButton);
//        add(Box.createHorizontalGlue());
//        add(countLabel);
//        add(Box.createHorizontalGlue());
//        add(nextButton);
    }

    public void setVisibleButtons(boolean checkButton, boolean nextButton) {
        this.checkButton.setVisible(checkButton);
        this.nextButton.setVisible(nextButton);
    }
}
