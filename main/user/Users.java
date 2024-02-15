package main.user;

import java.util.ArrayList;

public class Users {
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser = null;

    @Override
    public String toString() {
        return users.toString();
    }

    public static void setUsers(ArrayList<User> users) {
        Users.users = users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser(String userName) {
        if(users == null) users = new ArrayList<>();
        return users.stream().filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public static boolean contains(String userName) {
        if(users == null) users = new ArrayList<>();
        return users.stream().anyMatch(user -> user.getName().equals(userName));
    }

    public static boolean login(User user) {
        if (users.contains(user)) {
            currentUser = user;
            System.out.println(user + "login successfully.");
            return true;
        } else {
            System.out.println(user + "login failed");
            return false;
        }
    }
}
