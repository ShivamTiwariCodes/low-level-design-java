package problems.splitwise.user;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    @Getter
    List<User> users;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int userId) {
        return users
                .stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .get();
    }

}
