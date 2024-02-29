package main.ui;

import main.program.tasks.Module;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;

public class AFTaskPanel extends JPanel {

    private JScrollPane scrollPane;
    private final JPanel buttonPanel;
    private final AFMainWindow mainWindow;
    private final int MAX_WIDTH = 300;

    public AFTaskPanel(AFMainWindow mainWindow) {
        this.mainWindow = mainWindow;

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout());
        //setLayout(new SpringLayout());
        //setBorder(new LineBorder(Color.green));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        //buttonPanel.setLayout(new SpringLayout());
        //buttonPanel.setBorder(new LineBorder(Color.red));

        scrollPane = new JScrollPane(buttonPanel);
        //scrollPane.setBorder(new LineBorder(Color.blue));
        setPreferredSize(new Dimension(MAX_WIDTH + 30, mainWindow.getSize().height));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        AdjustmentListener listener = new AdjustmentListener() {
            private boolean isScrollBarVisible = false;
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                boolean currentScrollBarVisible = scrollPane.getVerticalScrollBar().isVisible();
                if (currentScrollBarVisible != isScrollBarVisible) {
                    //change the width of the buttons, depending on whether the ScrollBar is visible or not.
                    if (currentScrollBarVisible) {
                        setWidthButtons(MAX_WIDTH + 6);
                    } else {
                        setWidthButtons(MAX_WIDTH + 24);
                    }

                    scrollPane.repaint();
                    isScrollBarVisible = currentScrollBarVisible;
                }
            }
        };

        scrollPane.getVerticalScrollBar().addAdjustmentListener(listener);
    }

    public void addModuleButton(Module module) {
        if (buttonPanel == null) return;
        AFTaskButton button = new AFTaskButton(module);
        buttonPanel.add(button);
        //button.setPreferredSize(new Dimension(0, 50));
        button.setMaximumSize(new Dimension(MAX_WIDTH + 30, 150));

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

    //removes all buttons from the panel
    public void clear() {
        buttonPanel.removeAll();
    }

    //changes the width of all buttons on the panel
    private void setWidthButtons(int width) {
        for(Component comp : buttonPanel.getComponents()) {
           comp.setMaximumSize(new Dimension(width, comp.getMaximumSize().height));
        }
    }
}
