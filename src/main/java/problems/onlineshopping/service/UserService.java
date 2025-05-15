package problems.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import problems.onlineshopping.model.User;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static UserService userServiceInstance;
    private List<User> users;

    private UserService() {
        this.users = new ArrayList<>();
    }

    public static UserService getInstance() {
        if (userServiceInstance == null) {
            synchronized (UserService.class) {
                if (userServiceInstance == null) {
                    userServiceInstance = new UserService();
                }
            }
        }
        return userServiceInstance;
    }

    public void registerUser(User user) {
        if (isUserExist(user)) {
            logger.warn("user registration failed because user with given user id already exist");
            return;
        }
        CartService cartService = CartService.getInstance();
        users.add(user);
        logger.info("User is registered.");
    }

    private boolean isUserExist(User user) {
        return users.stream().anyMatch(u -> u.getId().equalsIgnoreCase(user.getId()));
    }

}
