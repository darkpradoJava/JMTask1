package DAO;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO implements UserDAO {

    private Connection connection = DBHelper.getMysqlConnection();

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from users");
            ResultSet result = stmt.getResultSet();
            result.next();
            while (true) {
                try {
                    long id = result.getLong(1);
                    String login = result.getString(2);
                    String password = result.getString(3);
                    String role = result.getString(4);
                    list.add(new User(id, login, password, role));
                    if (result.isLast()) {
                        break;
                    }
                    result.next();
                } catch (Exception e) {
                    result.close();
                    stmt.close();
                    return list;
                }
            }
            result.close();
            stmt.close();
            return list;
        } catch (SQLException ignore) {

        }
        return list;
    }

    @Override
    public void addUser(User user) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO users SET login ='" + user.getLogin() +
                    "', password = '" + user.getPassword() +
                    "', role = '" + user.getRole() + "'");
            stmt.close();
        } catch (SQLException ignore) {

        }
    }

    @Override
    public void editUser(User user) {
        try {
            String sql = "UPDATE users set login=?, password=?, role=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ignore) {

        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM users WHERE id = '" + user.getId() + "'");
        } catch (SQLException ignore) {

        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from users where id = '" + id + "'");
            ResultSet result = stmt.getResultSet();
            result.next();

            long idRes = result.getLong(1);
            String loginRes = result.getString(2);
            String passwordRes = result.getString(3);

            return new User(idRes, loginRes, passwordRes);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from users where login = '" + login + "'");
            ResultSet result = stmt.getResultSet();
            result.next();

            long idRes = result.getLong(1);
            String loginRes = result.getString(2);
            String passwordRes = result.getString(3);
            String roleRes = result.getString(4);

            return new User(idRes, loginRes, passwordRes, roleRes);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean validateUser(String login, String password) {
        User user = getUserByLogin(login);
        return user.getPassword().equals(password);
    }
}
