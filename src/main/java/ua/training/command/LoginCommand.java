package ua.training.command;

import ua.training.model.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command{
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getMethod().equals("GET")){
            return "/login.jsp";
        }
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login == null || login.equals("") || password == null || password.equals("")){
            return "/login.jsp";
        }
        Optional<User> user = userService.login(login);
        if(user.isPresent()){
            request.getSession().setAttribute("login", user.get().getLogin());
            request.getSession().setAttribute("role", user.get().getRole());
            System.out.println("login succesfull");
        }else{
            System.out.println("failed");
        }
        return "redirect:";
    }
}
