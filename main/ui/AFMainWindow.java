package main.ui;

import main.program.Main;
import main.tasks.ModuleContainer;
import main.tasks.Module;
import main.user.User;
import main.user.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AFMainWindow {

    private JFrame mainFrame;
    private AFHeaderPanel headerPanel;
    private AFTaskPanel tasksPanel;
    private AFMainPanel mainPanel;

    public AFMainWindow() {
        createComponents();
    }

    private void createComponents() {
        mainFrame = new JFrame("Learn english");
        headerPanel = new AFHeaderPanel();
        mainPanel = new AFMainPanel();
        tasksPanel = new AFTaskPanel(mainPanel);

        initializeHeader();
        initializeTasks();

        mainPanel.setTaskSubject(ModuleContainer.getModules().getFirst());

        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setUndecorated(true);

        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(tasksPanel, BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void initializeHeader() {
        //добавление кнопки регистрации
        headerPanel.addButton("Register", AFHeaderPanel.Align.RIGHT).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AFCustomDialog dialog = new AFCustomDialog(mainFrame, "Register");
                dialog.okButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //текст который пользователь ввёл в окне регистрации
                        String inputText = dialog.textField.getText();

                        if (inputText.isEmpty()) { //текст пустой
                            dialog.showMessage("Field is empty.");
                        } else if (Users.contains(inputText)) { //пользователь с таким именем уже существует
                            dialog.showMessage(String.format("A user named %s already exists", inputText));
                        } else {
                            dialog.dispose();
                        }
                    }
                });

                String result = dialog.showDialog();
                System.out.println(result);
                Main.createUser(result);
            }
        });

        //добавление кнопки авторизации
        headerPanel.addButton("Sign In", AFHeaderPanel.Align.RIGHT).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AFCustomDialog dialog = new AFCustomDialog(mainFrame, "Sign in");
                dialog.okButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //текст которыйввёл пользователь
                        String inputText = dialog.textField.getText();
                        if (inputText.isEmpty()) { //текст пустой
                            dialog.showMessage("Field is empty.");
                        } else if (!Users.contains(inputText)) { //пользователь не найден
                            dialog.showMessage(String.format("The user named %s was not found", inputText));
                        } else {
                            dialog.dispose();
                        }
                    }
                });

                String result = dialog.showDialog();
                User user = Users.getUser(result);
                if (Users.login(user)) {
                    headerPanel.setText(user.getName());
                }
            }
        });

        //добавление кнопки выхода из программы
        headerPanel.addButton("Exit", AFHeaderPanel.Align.RIGHT).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.exit();
            }
        });
    }

    private void initializeTasks() {
        for (Module subject : ModuleContainer.getModules()) {
            tasksPanel.addTaskSubjectButton(subject);
        }
    }
}
