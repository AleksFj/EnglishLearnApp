package main.ui;

import main.tasks.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AFTaskPanel extends JPanel {

    private final int panelWidth;
    private final JPanel buttonPanel;

    private final AFMainPanel mainPanel;

    public AFTaskPanel(AFMainPanel mainPanel) {
        this.mainPanel = mainPanel;

        panelWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * (25 / 100.0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setPreferredSize(new Dimension(panelWidth, 0));

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    public void addTaskSubjectButton(Module subject) {
        if (buttonPanel == null) return;
        AFTaskButton button = new AFTaskButton(subject);
        buttonPanel.add(button);
        button.setMaximumSize(new Dimension(panelWidth, 120));

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do nothing if the topic of the task is the same as the one the user is trying to open,
                // which would avoid idle screen refresh
                if(mainPanel.getTaskSubject().equals(subject)) return;
                mainPanel.setTaskSubject(subject);
            }
        });
    }
}
