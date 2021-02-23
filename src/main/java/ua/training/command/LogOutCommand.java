package ua.training.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession();

        session.removeAttribute("login");
        session.removeAttribute("password");
        session.removeAttribute("role");

        System.out.println(request.getContextPath());

        return "redirect:";
    }
}
