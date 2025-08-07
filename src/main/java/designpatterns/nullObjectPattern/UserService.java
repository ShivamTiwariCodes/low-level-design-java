package designpatterns.nullObjectPattern;

import java.util.ArrayList;
import java.util.List;

public class UserService {


    List<User> usersList = new ArrayList<>();
    int count=0;

    public void addUser(String name) {
        usersList.add(new ValidUser(count++, name));
    }

    public User getUser(int id) {
        for(User user: usersList) {
            if(user.getId() == id) return user;
        }
        return new NullUser();
    }

}
