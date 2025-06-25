package problems.onlinestockbrokeragesystem.service;

import problems.onlinestockbrokeragesystem.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private AccountService accountService;
    private static volatile UserService userService;

    private Map<String, User> users;

    private UserService() {
        this.users = new HashMap<>();
        this.accountService = AccountService.getInstance();
    }

    public static UserService getInstance() {
        if(userService == null) {
            synchronized (UserService.class) {
                if(userService == null) {
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    public void register(User user) {
        if(!users.containsKey(user.getUserId())) {
            this.users.putIfAbsent(user.getUserId(), user);
            this.accountService.createAccount(user.getUserId());
        }
    }

    public void getUser(String userId) {
        users.getOrDefault(userId, null);
    }
}
