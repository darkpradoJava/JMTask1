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

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

}
