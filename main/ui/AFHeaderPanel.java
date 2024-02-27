package main.ui;

import main.program.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class AFHeaderPanel extends JPanel {

    enum Align {
        LEFT,
        RIGHT
    }

    private JToolBar toolBar = new JToolBar();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JLabel textLabel;

    public AFHeaderPanel() {

        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new BorderLayout());

        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(Color.white);
        toolBar.add(leftPanel);
        toolBar.add(rightPanel);

        textLabel = new JLabel();
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        textLabel.setFont(Fonts.COURIERNEW_PLAIN_24);
        textLabel.setBackground(Color.red);
        leftPanel.add(textLabel);

        add(toolBar);
    }

    public AFCustomButton addButton(String text, Align align) {
        AFCustomButton button = new AFCustomButton(text);
        switch (align) {
            case LEFT:
                leftPanel.add(button);
                break;
            case RIGHT:
                rightPanel.add(button);
                break;
        }
        return button;
    }

    public void setText(String text) {
        textLabel.setText(text);
    }
}
