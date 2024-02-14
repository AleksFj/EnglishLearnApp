package main.ui;

import main.tasks.Module;
import main.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AFTaskButton extends AFCustomButton {

    private final JPanel textPanel;
    private final Module taskSubject;

    public AFTaskButton(Module taskSubject) {
        super(taskSubject.getTitle());

        this.taskSubject = taskSubject;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("<html> " + taskSubject.getTitle() + "</html>");
        //JLabel additionalLabel = new JLabel(additional);
        JProgressBar progressBar = new JProgressBar();

        headerLabel.setFont(Fonts.COURIERNEW_PLAIN_24);
        //additionalLabel.setFont(Fonts.COURIERNEW_PLAIN_16);

        //  additionalLabel.setForeground(Color.GRAY);

        textPanel = new JPanel(new GridLayout(1, 1));
        textPanel.setBackground(color);
        textPanel.add(headerLabel);
        //    textPanel.add(additionalLabel);

        progressBar.setBackground(Color.white);
        progressBar.setFont(Fonts.COURIERNEW_BOLD_12);
        progressBar.setValue(new Random().nextInt(100));
        progressBar.setStringPainted(true);

        add(textPanel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textPanel.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textPanel.setBackground(color);
            }
        });
    }

    public Module getTaskSubject() {
        return taskSubject;
    }
}
