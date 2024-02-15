package main.program;

import main.tasks.ModuleManager;
import main.user.User;
import main.user.Users;
import main.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final String ROOT_DIR = "";
    public static final String FILES_DIR = ROOT_DIR + "files/";

    public static void main(String[] args) {
        Users.load();
        loadTaskSubjects();
        new UserInterface();
    }

    public static void exit() {
        System.exit(0);
    }

    private static void loadTaskSubjects() {
        ModuleManager.createDefaultSubjects();
    }
}
