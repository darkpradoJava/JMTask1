package service;

import DAO.UserDao;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserService {

    private static UserService userService;

    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public void addUser(User user) {
        UserDao dao = new UserDao(sessionFactory.openSession());
        dao.addUser(user);
    }

    public List<User> getAllUser() {
        UserDao dao = new UserDao(sessionFactory.openSession());
        return dao.getAllUser();
    }

}
