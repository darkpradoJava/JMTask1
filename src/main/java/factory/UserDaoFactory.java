package factory;

import DAO.HibernateUserDAO;
import DAO.JDBCUserDAO;
import DAO.UserDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
            properties.load(new FileInputStream(new File("src/main/resources/dao.property")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties.getProperty("dao").equalsIgnoreCase("Hibernate")) {
            return new HibernateUserDAO();
        } else if (properties.getProperty("dao").equalsIgnoreCase("JDBC")) {
            return new JDBCUserDAO();
        } else {
            return new JDBCUserDAO();
        }
    }

}
