package main.program;

import main.ui.AFMainWindow;

public class UserInterface {
    private static AFMainWindow mainWindow = null;

    public UserInterface() {
        if(mainWindow != null) return;
        mainWindow = new AFMainWindow();
    }
    public static AFMainWindow getMainWindow() {
        return mainWindow;
    }
}
