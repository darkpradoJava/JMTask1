package filter;

import model.User;
import model.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class adminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String role = (String) request.getSession().getAttribute("role");

        if (role == null) {
            request.getRequestDispatcher("/login").forward(request, response);
        }

        if (role.equals(String.valueOf(UserRole.admin))) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/user").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
