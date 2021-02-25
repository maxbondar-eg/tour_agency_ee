package ua.training.command;

import ua.training.dto.TourOrderDTO;
import ua.training.service.TourOrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrdersCommand implements Command{
    TourOrderService orderService = new TourOrderService();

    @Override
    public String execute(HttpServletRequest request) {
        List<TourOrderDTO> orders = orderService.findRegistered();
        request.setAttribute("orders", orders);
        return "/orders.jsp";
    }
}
