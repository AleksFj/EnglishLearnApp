package main.program.user;

import main.program.events.ILoggedInListener;
import main.program.tasks.Module;
import main.program.tasks.ModuleContainer;
import main.program.tasks.ModuleManager;
import main.program.utils.Constants;
import main.program.utils.FileManager;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private ArrayList<Module> modules = new ArrayList<>();
    private static User currentUser = null;
    private static final transient List<ILoggedInListener> listeners = new ArrayList<>();
    private boolean isGuest = false;

    private User(String name) {
        currentUser = this;
        this.name = name;
        System.out.println("User " + name + " created successfully!");
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    @Override
    public String toString() {
        return name + " Modules (" + modules.size() + "): " + modules;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public static void registerNewUser(String name) {
        User user = new User(name);
        ModuleManager.createDefaultSubjects();
        ModuleManager.loadFromFiles();
        ModuleContainer.getModules().forEach(user::addModule);
        user.save();
        //new UserFileManager().save(user);
    }

    public static User loadUser(String userName) {
        //return new FileManager().loadUser(userName);
        User user = new FileManager().load(User.class, Constants.USERS_DIR + userName + ".json");
        //System.out.println(user);
        return user;
    }

    public static User createGuest() {
        User user = new User("Guest");
        user.isGuest = true;
        //ModuleManager.createDefaultSubjects();
        ModuleContainer.getModules().forEach(user::addModule);
        return user;
    }

    public static User create(String userName) {
        return new User(userName);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean alreadyExists(String userName) {
        return  FileManager.exists(Constants.USERS_DIR + userName + ".json");
    }

    public void signIn() {
        //System.out.println(this + " logged in.");
        for(ILoggedInListener listener : listeners) {
            listener.onLoggedIn(currentUser);
        }
    }

    public static void addLoggedInListener(ILoggedInListener listener) {
        listeners.add(listener);
    }

    public void save() {
        new FileManager().save(currentUser, Constants.USERS_DIR + getName());
    }

    public boolean isGuest() {
        return this.isGuest;
    }
}
