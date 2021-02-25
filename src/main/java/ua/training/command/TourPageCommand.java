package ua.training.command;

import ua.training.model.OrderStatus;
import ua.training.model.Tour;
import ua.training.model.TourOrder;
import ua.training.model.User;
import ua.training.service.TourOrderService;
import ua.training.service.TourService;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class TourPageCommand implements Command{
    TourService tourService = new TourService();
    UserService userService = new UserService();
    TourOrderService orderService = new TourOrderService();

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getMethod().equals("GET")){
            int tourId = Integer.parseInt(request.getParameter("tourId"));
            Optional<Tour> tour = tourService.findById(tourId);
            System.out.println("In method");
            if(tour.isPresent()){
                request.setAttribute("tour", tour.get());
            }else{
                throw new RuntimeException("Tour Not Exist");
            }
            return "/tourpage.jsp";
        }

        final HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("login");
        Optional<User> user = userService.login(userLogin);
        int tourId = Integer.parseInt(request.getParameter("tourId"));
        Optional<Tour> tour = tourService.findById(tourId);
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if(user.isPresent() && tour.isPresent()){
            TourOrder order = new TourOrder();
            order.setCustomer(user.get());
            order.setTour(tour.get());
            order.setTicketsQuantity(quantity);
            order.setStatus(OrderStatus.REGISTERED);
            orderService.add(order);
        }


        return "redirect:/cabinet";
    }
}
