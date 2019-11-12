package DAO;

import model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public void addUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> getAllUser() {
        session.beginTransaction();
        List<User> list = new ArrayList<>(session.createQuery("from User").list());
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void deleteUser(User user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
