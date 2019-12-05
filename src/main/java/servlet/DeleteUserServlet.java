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

@WebServlet("/admin/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {
            id = (long)-1;
        }
        userService.deleteUserById(id);
        resp.setContentType("text/html;charset=utf-8");
        List<User> list = userService.getAllUsers();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pageForAdmin.jsp");
        dispatcher.forward(req, resp);
    }

}
