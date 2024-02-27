package main.program.tasks;

import java.util.ArrayList;
import java.util.List;

public class ModuleContainer {
    private static final List<Module> modules = new ArrayList<>();

    public static void addModule(Module module) {
        modules.add(module);
        //System.out.println(module.getTitle() + " added to container");
    }

    public static List<Module> getModules() {
        return modules;
    }

    public static void removeAll() {
        modules.clear();
    }
}
