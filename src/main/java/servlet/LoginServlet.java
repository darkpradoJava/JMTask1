package servlet;

import model.User;
import model.UserRole;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        if (isLoginPasswordEmpty(login, password)) {
            if (userService.validateUser(login, password)) {
                User user = userService.getUserByLogin(login);
                HttpSession session = req.getSession();
                resp.setContentType("text/html");
                session.setAttribute("login", user.getLogin());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("role", user.getRole());
                if (user.getRole().equals(String.valueOf(UserRole.user))) {
                    req.getRequestDispatcher("pageForUser.jsp").forward(req, resp);
                }
                if (user.getRole().equals(String.valueOf(UserRole.admin))) {
                    req.getRequestDispatcher("admin").forward(req, resp);
                }
            }
        } else {
            doGet(req, resp);
        }
    }

    private boolean isLoginPasswordEmpty(String login, String password) {
        return login != null && !login.isEmpty() &&
                password != null && !password.isEmpty();
    }
}
