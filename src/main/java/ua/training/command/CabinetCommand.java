package ua.training.command;

import ua.training.dto.TourOrderDTO;
import ua.training.model.User;
import ua.training.service.TourOrderService;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class CabinetCommand implements Command{
    UserService userService = new UserService();
    TourOrderService orderService = new TourOrderService();

    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("login");
        Optional<User> user = userService.login(userLogin);
        if(user.isPresent()){
            request.setAttribute("user", user.get());
        }else{
            throw new RuntimeException("User Not Found");
        }
        List<TourOrderDTO> userOrders = orderService.findAllByUserId(user.get().getId());
        request.setAttribute("userOrders", userOrders);
        return "/cabinet.jsp";
    }
}
