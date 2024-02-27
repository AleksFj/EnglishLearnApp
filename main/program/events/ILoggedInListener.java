package main.program.events;

import main.program.user.User;

public interface ILoggedInListener {
    void onLoggedIn(User user);
}
