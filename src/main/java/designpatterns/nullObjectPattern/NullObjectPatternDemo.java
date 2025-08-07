package designpatterns.nullObjectPattern;

public class NullObjectPatternDemo {


    public void run() {

        UserService userService = new UserService();
        userService.addUser("User1");
        userService.addUser("User2");
        userService.addUser("User3");

        User user1 = userService.getUser(0);
        System.out.println("User1 after creation : isvalid -> " + user1.isValid() + " , name -> " + user1.getName());

        User user2 = userService.getUser(1);
        System.out.println("User4 after creation : isvalid -> " + user2.isValid() + " , name ->  " + user2.getName());

        User user3 = userService.getUser(2);
        System.out.println("User4 after creation : isvalid -> " + user3.isValid() + " , name ->  " + user3.getName());

        User user4 = userService.getUser(3);
        System.out.println("User4 before creation : isvalid -> " + user4.isValid() + " , name ->  " + user4.getName());

        userService.addUser("user4");
        user4 = userService.getUser(3);
        System.out.println("User4 after creation : isvalid -> " + user4.isValid() + " , name ->  " + user4.getName());
    }
}
