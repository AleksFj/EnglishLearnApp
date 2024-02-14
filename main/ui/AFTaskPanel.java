package main.ui;

import main.tasks.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AFTaskPanel extends JPanel {

    private int panelWidth;
    private final JPanel buttonPanel;

    private AFMainPanel mainPanel;

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
                mainPanel.setTaskSubject(subject);
            }
        });
    }
}
