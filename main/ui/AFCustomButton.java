package main.ui;

import main.program.utils.Fonts;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AFCustomButton extends javax.swing.JButton {

    //определяет нормальный цвет и цвет при наведения мыши
    final protected Color color = new Color(0.93f, 0.95f, 0.94f);
    final protected Color hoverColor = new Color(0.96f, 0.95f, 0.94f);

    public AFCustomButton(String text) {
        super(text);

        setFont(Fonts.COURIERNEW_PLAIN_16);
        setFocusPainted(false);
        setUI(new BasicButtonUI());

        LineBorder customBorder = new LineBorder(Color.white, 1);
        EmptyBorder emptyBorder = new EmptyBorder(getInsets());

        setBorder(new CompoundBorder(customBorder, emptyBorder));
        setBackground(color);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setColor(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setColor(color);
            }
        });
    }

    protected void setColor(Color color) {
        setBackground(color);
    }
}
