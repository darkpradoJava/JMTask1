package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class UsersServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<User> list = userService.getAllUsers();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("table.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("delete".equals(req.getParameter("action"))) {
            doDelete(req, resp);
        } else if ("update".equals(req.getParameter("action"))) {
           doPut(req, resp);
        } else {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (login != null && !login.equals("") && password != null && !password.equals("")) {
                User user = new User(login, password);
                userService.addUser(user);
            }
            List<User> list = userService.getAllUsers();
            req.setAttribute("list", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("table.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {
            id = (long)-1;
        }
        userService.deleteUserById(id);
        List<User> list = userService.getAllUsers();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("table.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {
            id = (long)-1;
        }

        User user = userService.getUserById(id);
        if (user != null) {
            if (login != null && !login.equals("")) {
                user.setLogin(login);
            }
            if (password != null && !password.equals("")) {
                user.setPassword(password);
            }
        }
        userService.editUser(user);
        List<User> list = userService.getAllUsers();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("table.jsp");
        dispatcher.forward(req, resp);
    }
}
