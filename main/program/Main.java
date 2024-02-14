package main.program;

import main.tasks.ModuleManager;
import main.user.User;
import main.user.Users;
import main.utils.FileHandler;

import java.util.ArrayList;

public class Main {

    public static final String ROOT_DIR = "";
    public static final String FILES_DIR = ROOT_DIR + "files/";
    public static final String USERS_FILE = FILES_DIR + "users.json";
    private static User user; //the current user who is using the application

    public static void main(String[] args) {

        loadUsers();
        loadTaskSubjects();
        new UserInterface();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void createUser(String name) {
        user = new User(name);
        Users.addUser(user);
        new FileHandler().saveUsers(Users.getUsers(), USERS_FILE);
    }

    private static void loadUsers() {
        ArrayList<User> users = new FileHandler().readUsers(USERS_FILE);
        Users.setUsers(users);
    }

    private static void loadTaskSubjects() {
        ModuleManager.createDefaultSubjects();
    }
}
