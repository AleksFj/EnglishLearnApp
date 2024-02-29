package main.ui;

import main.program.events.ILoggedInListener;
import main.program.Main;
import main.program.tasks.ModuleContainer;
import main.program.tasks.Module;
import main.program.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AFMainWindow {

    private JFrame mainFrame;
    private AFHeaderPanel headerPanel;
    private AFTaskPanel tasksPanel;
    private AFMainPanel mainPanel;

    public AFMainWindow() {
        createComponents();
    }

    private void createComponents() {

        User.addLoggedInListener(new ILoggedInListener() {
            @Override
            public void onLoggedIn(User user) {
                headerPanel.setText(user.getName());
                tasksPanel.clear();
                user.getModules().forEach(tasksPanel::addModuleButton);

                ArrayList<Module> modules = user.getModules();
                if(!modules.isEmpty()) {
                    mainPanel.setCurrentModule(modules.getFirst());
                }
            }
        });

        mainFrame = new JFrame("Learn english");
        headerPanel = new AFHeaderPanel();
        mainPanel = new AFMainPanel();
        tasksPanel = new AFTaskPanel(this);

        initializeHeader();
        initializeTasks();

        //mainPanel.setCurrentModule(ModuleContainer.getModules().getFirst());
        //mainPanel.nextExercise(ModuleContainer.getModules().getFirst());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth() / 2;
        int screenHeight = (int) screenSize.getHeight() / 2;

        // Устанавливаем размеры и положение фрейма
        mainFrame.setSize(800, 600);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setLocation(screenWidth / 2, screenHeight / 2);

        //mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mainFrame.setUndecorated(true);

        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(tasksPanel, BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public Dimension getSize() {
        return mainFrame.getSize();
    }

    public AFMainPanel getMainPanel() {
        return mainPanel;
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
                        //text entered by the user in the registration window
                        String inputText = dialog.getInputText();

                        if (inputText.isEmpty()) { //empty text
                            dialog.showMessage("Field is empty.");
                        } else if (User.alreadyExists(inputText)) { //user with this name already exists
                            dialog.showMessage(String.format("A user named %s already exists", inputText));
                        } else if(inputText.equalsIgnoreCase("Guest")){
                            dialog.showMessage("The name Guest is reserved. Please choose a different name.");
                        } else {
                            dialog.dispose();
                        }
                    }
                });

                //the result of a pressed button (OK or CANCEL)
                if(dialog.showDialog() == AFCustomDialog.ID_OK) {
                    String inputText = dialog.getInputText();
                    User.registerNewUser(inputText);
                //    Users.createUser(inputText);
                }
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
                        //текст который ввёл пользователь
                        String inputText = dialog.getInputText();
                        if (inputText.isEmpty()) { //текст пустой
                            dialog.showMessage("Field is empty.");
                        } else if (!User.alreadyExists(inputText)) { //пользователь не найден
                            dialog.showMessage(String.format("The user named %s was not found", inputText));
                        } else {
                            dialog.dispose();
                        }
                    }
                });

                //the result of a pressed button (OK or CANCEL)
                if(dialog.showDialog() == AFCustomDialog.ID_OK) {
                    String inputText = dialog.getInputText();
                    User.loadUser(inputText).signIn();
                }
//
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
        for (Module module : ModuleContainer.getModules()) {
            //System.out.println(module.getTitle());
            tasksPanel.addModuleButton(module);
        }
    }
}
