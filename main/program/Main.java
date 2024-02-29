package main.program;

import main.program.tasks.ModuleManager;
import main.program.user.User;

public class Main {

    public static void main(String[] args) {
//        Module module = new FileManager().load(Module.class, FINAL.LESSONS_DIR + "articles.json");
//        ModuleContainer.addModule(module);

        loadModules();
        UserInterface.create();
        User.createGuest().signIn();
    }

    public static void exit() {
        System.exit(0);
    }

    private static void loadModules() {
        ModuleManager.createDefaultSubjects();
        ModuleManager.loadFromFiles();
    }
}