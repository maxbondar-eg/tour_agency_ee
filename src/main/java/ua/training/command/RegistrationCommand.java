package ua.training.command;

import ua.training.model.Role;
import ua.training.model.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command{

    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getMethod().equals("GET")){
            return "/registration.jsp";
        }
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if(login == null || login.equals("") || password == null || password.equals("") ||
        firstName == null || firstName.equals("") || lastName == null || lastName.equals("")){
            return "/registration.jsp";
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(Role.USER);
        System.out.println(user.getFirstName());
        userService.addUser(user);
        return "redirect:/";
    }
}
