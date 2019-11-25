package service;

import DAO.UserDAO;
import DAO.HibernateUserDAO;
import DAO.JDBCUserDAO;
import factory.UserDaoFactory;
import model.User;
import util.DBHelper;

import java.util.List;

public class UserService implements Service {

    private static UserService instance;
    private UserDaoFactory userDaoFactory = UserDaoFactory.getInstance();
    private UserDAO dao = userDaoFactory.getDao();

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {
        User user = dao.getUserById(id);
        if (user != null) {
            dao.deleteUser(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    public void editUser(User user) {
        if (user != null) {
            dao.editUser(user);
        }
    }

}
