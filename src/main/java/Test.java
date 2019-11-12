import model.User;
import service.UserService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        User user = new User("login", "password");
//        User user2 = new User("login2", "password2");
//        UserService.getInstance().addUser(user);
//        UserService.getInstance().addUser(user2);
        List<User> list = UserService.getInstance().getAllUser();
        for (User tmpUser : list) {
            System.out.println(tmpUser.toString());
        }
    }
}
