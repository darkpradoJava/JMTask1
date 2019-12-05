package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String login = (String) req.getSession().getAttribute("login");
        String password = (String) req.getSession().getAttribute("password");
        String role = (String) req.getSession().getAttribute("role");

        req.setAttribute("login", login);
        req.setAttribute("password", password);
        req.setAttribute("role", role);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pageForUser.jsp");
        dispatcher.forward(req, resp);
    }
}
