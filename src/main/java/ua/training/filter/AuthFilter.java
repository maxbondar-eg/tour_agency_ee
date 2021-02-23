package ua.training.filter;

import ua.training.dao.UserDAO_old;
import ua.training.model.Role;
import ua.training.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final String login = req.getParameter("login");

         UserService userService = new UserService();

        final HttpSession session = req.getSession();
        session.setAttribute("test", "Hello from servlet");

        if(nonNull(session) && nonNull(session.getAttribute("login"))){
            final Role role = (Role) session.getAttribute("role");
            moveToMenu(req, resp, role);
        } else if(userService.login(login).isPresent()){
            final Role role = userService.login(login).get().getRole();

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, resp, role);
        } else {
            moveToMenu(req, resp, Role.GUEST);
        }

        chain.doFilter(request, response);
    }

    private void moveToMenu(HttpServletRequest req, HttpServletResponse resp, Role role) throws IOException {
        if((req.getRequestURI().contains("admin") && !role.equals(Role.ADMIN)) ||
                (req.getRequestURI().contains("user") && !role.equals(Role.ADMIN))){
            throw new RuntimeException("Access denied");
        }else if(role.equals(Role.GUEST)){
            resp.sendRedirect("/login");
        }
    }
}
