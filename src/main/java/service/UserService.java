package service;

import DAO.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private static UserService userService = new UserService();
    UserDao dao = UserDao.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(User user) {
        dao.addUser(user);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

}
