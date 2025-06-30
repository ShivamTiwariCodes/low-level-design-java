package problems.carrentalsystem.services;

import common.exceptions.UserNotFoundException;
import problems.carrentalsystem.models.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {

    public static volatile UserService userServiceInstance;
    private final Map<String, User> users;

    private UserService() {
        this.users = new ConcurrentHashMap<>();
    }

    public static UserService getCarServiceInstance() {
        if(userServiceInstance == null) {
            synchronized (UserService.class) {
                if(userServiceInstance == null) {
                    userServiceInstance = new UserService();
                }
            }
        }
        return userServiceInstance;
    }

    public void register(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.getOrDefault(userId, null);
    }

    public synchronized void updateUser(String userId, String key, Object value) {
        User user = getUserOrThrow(userId);
        switch (key) {
            case "name":
                user.setName((String) value);
            default:
                System.out.println("Provide the valid key");
        }
    }

    public User getUserOrThrow(String userId) {
        User user = users.get(userId);
        if(user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
