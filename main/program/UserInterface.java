package main.program;

import main.program.user.User;
import main.ui.AFMainWindow;

public abstract class UserInterface {
    private static AFMainWindow mainWindow = null;

    public static boolean create() {
        if(mainWindow != null) return false;
        mainWindow = new AFMainWindow();
        return true;
    }

    public static AFMainWindow getMainWindow() {
        return mainWindow;
    }
}
