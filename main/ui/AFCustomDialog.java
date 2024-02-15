package main.ui;

import main.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//модальное диалоговое окно
public class AFCustomDialog extends JDialog {
    public static final int ID_CANCEL = 0;
    public static final int ID_OK = 1;

    private AFCustomTextField textField;   //текстовое поле для пользовательского ввода
    private JTextArea messageLabel; //сообщение которое показывается в диалогово окне
    private String result;  //результат возвращается при нажатии на кнопку "ОК"

    public final AFCustomButton okButton;   //кнопка "ОК"
    public final AFCustomButton cancelButton;   //кнопка "Отмена"
    private int buttonResult = -1;
    private String inputText;

    public AFCustomDialog(JFrame parent, String text) {
        super(parent, text, true);

        setLayout(new BorderLayout());

        setType(Type.POPUP);
        setModal(true);
        setFocusableWindowState(true);
        setPreferredSize(new Dimension(400, 200));
        setResizable(false);

        //создание текстового поля для пользовательского ввода
        textField = new AFCustomTextField(15);

        JLabel label = new JLabel("Name:");
        label.setLabelFor(textField);

        //создание и установки для текста сообщения
        messageLabel = new JTextArea();
        messageLabel.setForeground(Color.red);                  //цвет текста - красный
        messageLabel.setFont(Fonts.COURIERNEW_PLAIN_16);
        messageLabel.setLineWrap(true);
        messageLabel.setEditable(false);
        messageLabel.setBackground(getBackground());

        //создание кнопок ок и отмена
        okButton = new AFCustomButton("OK");
        cancelButton = new AFCustomButton("Cancel");

        //закрытие окна при нажатии на кнопку отмена
        cancelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonResult = ID_CANCEL;
                inputText = textField.getText();
                dispose();
            }
        });

        okButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonResult = ID_OK;
                inputText = textField.getText();
            }
        });

        //панель для текстового поля пользовательского ввода, располагается сверху
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout());
        textFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textFieldPanel.add(label);
        textFieldPanel.add(textField, BorderLayout.NORTH);

        //панель для текста сообщения
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout());
        messagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        messagePanel.add(messageLabel);

        //панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Выравнивание кнопок по правому краю
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(textFieldPanel, BorderLayout.NORTH);
        add(messagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);

        messageLabel.setVisible(true);
    }

    public int showDialog() {
        setVisible(true);
        return buttonResult;
    }

    public String getInputText() {
        return textField.getText();
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
