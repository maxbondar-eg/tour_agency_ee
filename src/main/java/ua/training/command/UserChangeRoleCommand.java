package ua.training.command;

import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserChangeRoleCommand implements Command{
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String role = request.getParameter("userRole");
        userService.changeRole(userId, role);
        return "redirect:/usercontrol";
    }
}
