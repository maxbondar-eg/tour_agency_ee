package ua.training.command;

import ua.training.model.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserControlCommand implements Command{
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = userService.findAll();
        request.setAttribute("users", users);
        return "/users.jsp";
    }
}
