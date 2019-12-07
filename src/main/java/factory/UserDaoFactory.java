package factory;

import DAO.UserDAO;

public class UserDaoFactory {

    private static UserDaoFactory instance;
    private Factory factory;

    private UserDaoFactory() {

    }

    public static UserDaoFactory getInstance() {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    public UserDAO getDao() {
        String config = PropertyDaoHelper.getTypeDao();
        System.out.println(config);
        if (config.equalsIgnoreCase("Hibernate")) {
            factory = new HibernateUserDaoFactory();
            return factory.createDao();
        } else if (config.equalsIgnoreCase("JDBC")) {
            factory = new JDBCUserDaoFactory();
            return factory.createDao();
        } else {
            factory = new JDBCUserDaoFactory();
            return factory.createDao();
        }
    }

}
