package factory;

import DAO.JDBCUserDAO;
import DAO.UserDAO;

public class JDBCUserDaoFactory implements Factory {

    @Override
    public UserDAO createDao() {
        return new JDBCUserDAO();
    }

}
