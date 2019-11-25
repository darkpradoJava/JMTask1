package service;

import model.User;

import java.util.List;

public interface Service {

    void addUser(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    User getUserById(Long id);
    void editUser(User user);

}
