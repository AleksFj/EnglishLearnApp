package main.program.user;

public class Users {
//    public static final String USERS_FILE = Main.FILES_DIR + "users.json";
//    public static final String USERS_DIR = Main.FILES_DIR + "users/";
//    //private static ArrayList<User> users = new ArrayList<>();
//    private static User currentUser = null;

//    @Override
//    public String toString() {
//        return users.toString();
//    }
//
//    public static void setUsers(ArrayList<User> users) {
//        Users.users = users;
//    }
//
//    public static void addUser(User user) {
//        users.add(user);
//    }
//
//    public static ArrayList<User> getUsers() {
//        return users;
//    }

//    public static User getUser(String userName) {
////        if(users == null) users = new ArrayList<>();
////        return users.stream().filter(user -> user.getName().equals(userName))
////                .findFirst()
////                .orElse(null);
//
//        try {
//            return new FileHandler().loadUser(userName);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static boolean contains(String userName) {
//        return FileHandler.exists(USERS_DIR + userName + ".json");
////        if(users == null) users = new ArrayList<>();
////        return users.stream().anyMatch(user -> user.getName().equals(userName));
//    }
//
//    /**
//     * A method for verifying user credentials and login credentials.
//     *
//     * @param user the object of the user who is trying to log in
//     * @return true, if the input is successful, otherwise false
//     */
//    public static boolean login(User user) {
//        return false;
//        // Check if the passed user is in the list of registered users
////        if (users.contains(user)) {
////            // If the user is found in the list, set it as the current user
////            currentUser = user;
////            System.out.println(user + "login successfully.");
////            return true;
////        } else {
////            // If the user is not found in the list, we display a message about unsuccessful login attempt
////            System.out.println(user + " login failed");
////            return false;
////        }
//    }
//
////    public static void load() {
////        ArrayList<User> users = new FileHandler().readUsers(USERS_FILE);
////        Users.setUsers(users);
////    }
//
//    public static void save(User user) {
//        try {
//            new FileHandler().saveUser(user, USERS_DIR);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        //    new FileHandler().saveUsers(Users.getUsers(), USERS_FILE);
//    }
//
//    public static void createUser(String name) {
//        User newUser = new User(name);
//        ModuleContainer.getModules().forEach(newUser::addModule);
//        //Users.addUser(newUser);
//        Users.save(newUser);
//    }
}
