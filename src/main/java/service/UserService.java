package service;

import DAO.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private static UserService userService = new UserService();
    private UserDao dao = new UserDao();

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

    public void deleteUserById(Long id) {
        User user = dao.getUserById(id);
        if (user != null) {
            dao.deleteUser(user);
        }
    }

    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    public void editUser(User user) {
        if (user != null) {
            dao.editUser(user);
        }
    }

}
