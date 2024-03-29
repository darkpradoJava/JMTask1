package servlet;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/add")
public class AddUserServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (login != null && !login.equals("") && password != null && !password.equals("")) {
            User user = new User(login, password, role);
            userService.addUser(user);

            resp.setContentType("text/html;charset=utf-8");
            List<User> list = userService.getAllUsers();
            req.setAttribute("list", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("../pageForAdmin.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
