package main.ui;

import main.program.utils.Fonts;

import javax.swing.*;

public class AFCustomTextField extends JTextField {

    public AFCustomTextField(int columns) {
        super(columns);

        setFont(Fonts.COURIERNEW_PLAIN_24);
    }
}
