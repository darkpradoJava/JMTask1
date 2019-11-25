package factory;

import DAO.HibernateUserDAO;
import DAO.JDBCUserDAO;
import DAO.UserDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

    private static UserDaoFactory instance;

    private UserDaoFactory() {

    }

    public static UserDaoFactory getInstance() {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    public UserDAO getDao() {
        Properties properties = new Properties();
        try {
            InputStream stream = UserDaoFactory.class.getClassLoader().getResourceAsStream("dao.property");
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String config = properties.getProperty("dao");
        System.out.println(config);
        if (config.equalsIgnoreCase("Hibernate")) {
            return new HibernateUserDAO();
        } else if (config.equalsIgnoreCase("JDBC")) {
            return new JDBCUserDAO();
        } else {
            return new JDBCUserDAO();
        }
    }

}
