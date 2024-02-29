package main.ui;

import main.program.events.IChangeListener;
import main.program.tasks.Module;
import main.program.utils.Fonts;
import main.program.utils.MathUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AFTaskButton extends AFCustomButton {

    private final JPanel textPanel;
    private final Module module;
    private final JProgressBar progressBar;

    public AFTaskButton(Module module) {
        super(module.getTitle());

        this.module = module;

        module.addChangeListener(new IChangeListener() {
            @Override
            public void onChange() {
                updateProgressBar();
            }
        });

        //setLayout(new GridLayout(0, 1));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new FlowLayout());

        JLabel headerLabel = new JLabel("<html> " + module.getTitle() + "</html>");

        headerLabel.setFont(Fonts.COURIERNEW_PLAIN_24);

        textPanel = new JPanel(new GridLayout(1, 1));
        textPanel.setBackground(color);
        textPanel.add(headerLabel);

        progressBar = new JProgressBar();
        progressBar.setBackground(Color.white);
        progressBar.setFont(Fonts.COURIERNEW_BOLD_12);
        progressBar.setStringPainted(true);
        updateProgressBar();

        add(textPanel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textPanel.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textPanel.setBackground(color);
            }
        });
    }

    private void updateProgressBar() {
        int current = module.current();
        int total = module.total();
        int percentage = (int)MathUtils.calculatePercentage(module.current(), module.total());
        progressBar.setString(String.format("%d%% (%d/%d)", percentage, current, total));
        progressBar.setValue(percentage);
    }

    public Module getModule() {
        return module;
    }
}
