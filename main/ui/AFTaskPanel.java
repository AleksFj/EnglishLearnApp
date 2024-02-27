package main.ui;

import main.program.tasks.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AFTaskPanel extends JPanel {

    private JScrollPane scrollPane;
    private final JPanel buttonPanel;
    private final AFMainWindow mainWindow;
    private final int MAX_WIDTH = 300;

    public AFTaskPanel(AFMainWindow mainWindow) {
        this.mainWindow = mainWindow;

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setPreferredSize(new Dimension(MAX_WIDTH + 30, mainWindow.getSize().height));
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    public void addModuleButton(Module module) {
        if (buttonPanel == null) return;
        AFTaskButton button = new AFTaskButton(module);
        buttonPanel.add(button);
//        button.setMaximumSize(new Dimension(MAX_WIDTH, 200));
//        button.setMinimumSize(new Dimension(MAX_WIDTH, 100));
        button.setPreferredSize(new Dimension(MAX_WIDTH, 150));

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do nothing if the topic of the task is the same as the one the user is trying to open,
                // which would avoid idle screen refresh
                //System.out.println("getModule(): " + mainWindow.getMainPanel().getModule());
                //System.out.println("module: "+ module);
                if(module.equals(mainWindow.getMainPanel().getModule())) return;
                //if (mainWindow.getMainPanel().getModule().equals(module)) return;
                mainWindow.getMainPanel().setCurrentModule(module);
            }
        });
    }

    public void clear() {
        buttonPanel.removeAll();
    }
}
