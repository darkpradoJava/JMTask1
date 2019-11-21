package DAO;

import model.User;

import java.util.List;

public interface DAO {

    List<User> getAllUsers();
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    User getUserById(Long id);

}