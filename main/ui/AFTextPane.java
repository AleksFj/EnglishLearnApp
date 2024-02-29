package main.ui;

import main.program.utils.Fonts;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class AFTextPane extends JTextPane {
    public AFTextPane() {
        setFont(Fonts.COURIERNEW_BOLD_24);
        setEditable(false);    //disallows editing
        setOpaque(false);  //removes the background

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        // Получаем StyledDocument и применяем стиль для всего текста
        StyledDocument doc = getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        setPreferredSize(new Dimension(0, 0));
    }

    public void hideCaret() {
        setHighlighter(null);  //disables text selection
        //The caret is overridden by the paint method so you don't have to draw anything
        setCaret(new DefaultCaret(){
            @Override
            public void paint(Graphics g) {

            }
        });
    }
}
