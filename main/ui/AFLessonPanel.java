package main.ui;

import main.utils.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AFLessonPanel extends JPanel {

    protected JLabel title;
    protected JLabel text;
    protected JLabel resultText;

    public AFLessonPanel() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(0, 1));

        title = new AFCenteredTextPane();
        title.setFont(Fonts.COURIERNEW_BOLD_32);
        add(title);

        text = new AFCenteredTextPane();
        text.setFont(Fonts.COURIERNEW_PLAIN_32);
        add(text);

        resultText = new JLabel();
        resultText.setFont(Fonts.COURIERNEW_BOLD_32);
        resultText.setBorder(new EmptyBorder(10, 50, 10, 50));
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public abstract boolean checkLesson();
}
