package factory;

import DAO.UserDAO;

public interface Factory {

    UserDAO createDao();

}
