package main.ui;

import main.program.utils.Fonts;

import javax.swing.*;
import java.awt.*;

public class AFResultMessagePrinter {

    private final JLabel text;
    private JPanel panel;

    public AFResultMessagePrinter(JPanel parent) {
        panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        text = new JLabel();
        text.setFont(Fonts.COURIERNEW_BOLD_32);
        //text.setBorder(new EmptyBorder(10, 50, 10, 50));
        panel.add(text);
        parent.add(panel);
    }

    public void setResult(boolean value) {

        if (value) {
            text.setText("Correct");
            text.setForeground(Color.green);
            text.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        } else {
            text.setText("Incorrect");
            text.setForeground(Color.red);
            text.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}

