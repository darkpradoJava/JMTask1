package factory;

import DAO.HibernateUserDAO;
import DAO.UserDAO;

public class HibernateUserDaoFactory implements Factory {

    @Override
    public UserDAO createDao() {
        return new HibernateUserDAO();
    }

}
