package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    public HibernateUserDAO() {
        sessionFactory = DBHelper.getSessionFactory();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list = new ArrayList<>(query.list());
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void editUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user;
        try {
            Query query = session.createQuery("from User where id = :id").setParameter("id", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            user = null;
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = null;
        try {
            Query query = session.createQuery("from User where login = :login").setParameter("login", login);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    @Override
    public boolean validateUser(String login, String password) {
        User user = getUserByLogin(login);
        return user.getPassword().equals(password);
    }
}
