package problems.movieticketbookingsystem.controller;

import java.util.ArrayList;
import java.util.List;

import problems.movieticketbookingsystem.models.User;

public class UserController {

    private List<User> users;

    private static  UserController userControllerInstance;
    private UserController() {
        this.users = new ArrayList<>();
    }

    public static  UserController getInstance() {
        if(userControllerInstance == null) {
            synchronized (UserController.class) {
                if(userControllerInstance == null) {
                    userControllerInstance = new UserController();
                }
            }
        }
        return userControllerInstance;
    }

    public boolean registerUser(User user) {
        if(isUserExist(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    private boolean isUserExist(User user) {
        boolean isFound = users.stream().anyMatch(u -> u.getId() == user.getId());
        return isFound;
    }

}