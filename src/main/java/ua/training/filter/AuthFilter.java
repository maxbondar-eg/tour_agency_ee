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

        if(nonNull(session) && nonNull(session.getAttribute("login"))){
            final Role role = (Role) session.getAttribute("role");
            moveToMenu(req, resp, role);
        } else if(userService.login(login).isPresent()){
            final Role role = userService.login(login).get().getRole();

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, resp, role);
        } else {
            System.out.println("GUest");
            moveToMenu(req, resp, Role.GUEST);
        }

        chain.doFilter(request, response);
    }

    private void moveToMenu(HttpServletRequest req, HttpServletResponse resp, Role role) throws IOException {
        if (role.equals(Role.GUEST) && !(req.getRequestURI().contains("registration") || req.getRequestURI().contains("login") || req.getRequestURI().equals("/controller"))) {
            throw new RuntimeException("Access denied");
        }

        if(role.equals(Role.USER) && (req.getRequestURI().contains("tourcontrol") || req.getRequestURI().contains("orders")
        || req.getRequestURI().contains("usercontrol"))){
            throw new RuntimeException("Access denied");
        }
    }
}
