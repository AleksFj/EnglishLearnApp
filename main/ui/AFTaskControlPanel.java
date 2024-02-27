package main.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AFTaskControlPanel extends JPanel {

    private JLabel countLabel;
    AFCustomButton checkButton;
    AFCustomButton nextButton;

    private AFMainPanel mainPanel;

    public AFTaskControlPanel(AFMainPanel mainPanel) {
        this.mainPanel = mainPanel;

        setPreferredSize(new Dimension(0, 50));

        checkButton = new AFCustomButton("Проверить");
        checkButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainPanel.getLessonPanel().checkLesson()) {
                    setVisibleButtons(false, true);
                }
            }
        });

        nextButton = new AFCustomButton("Продолжить");
        nextButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.nextExercise();
            }
        });

        setVisibleButtons(false, false);

        add(checkButton);
        add(nextButton);
    }

    public void setVisibleButtons(boolean checkButton, boolean nextButton) {
        this.checkButton.setVisible(checkButton);
        this.nextButton.setVisible(nextButton);
    }
}
